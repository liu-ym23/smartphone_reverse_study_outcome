package com.android.server.audio;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.PlayerBase;
import android.media.SoundPool;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.PrintWriterPrinter;
import com.android.internal.util.XmlUtils;
import com.android.server.utils.EventLogger;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
class SoundEffectsHelper {
    private static final String ASSET_FILE_VERSION = "1.0";
    private static final String ATTR_ASSET_FILE = "file";
    private static final String ATTR_ASSET_ID = "id";
    private static final String ATTR_GROUP_NAME = "name";
    private static final String ATTR_VERSION = "version";
    private static final int EFFECT_NOT_IN_SOUND_POOL = 0;
    private static final String GROUP_TOUCH_SOUNDS = "touch_sounds";
    private static final int MSG_LOAD_EFFECTS = 0;
    private static final int MSG_LOAD_EFFECTS_TIMEOUT = 3;
    private static final int MSG_PLAY_EFFECT = 2;
    private static final int MSG_UNLOAD_EFFECTS = 1;
    private static final int NUM_SOUNDPOOL_CHANNELS = 4;
    private static final int SOUND_EFFECTS_LOAD_TIMEOUT_MS = 15000;
    private static final String SOUND_EFFECTS_PATH = "/media/audio/ui/";
    private static final String TAG = "AS.SfxHelper";
    private static final String TAG_ASSET = "asset";
    private static final String TAG_AUDIO_ASSETS = "audio_assets";
    private static final String TAG_GROUP = "group";
    private final Context mContext;
    private final int[] mEffects;
    private final Consumer<PlayerBase> mPlayerAvailableCb;
    private final List<Resource> mResources;
    private final int mSfxAttenuationDb;
    private SfxHandler mSfxHandler;
    private final EventLogger mSfxLogger;
    private SfxWorker mSfxWorker;
    private SoundPool mSoundPool;
    private SoundPoolLoader mSoundPoolLoader;

    interface OnEffectsLoadCompleteHandler {
        void run(boolean r1);
    }

    private static final class Resource {
        final String mFileName;
        boolean mLoaded;
        int mSampleId;

        Resource(String fileName) {
            this.mFileName = fileName;
            this.mSampleId = 0;
        }

        void unload() {
            this.mSampleId = 0;
            this.mLoaded = false;
        }
    }

    private class SfxHandler extends Handler {
        final /* synthetic */ SoundEffectsHelper this$0;

        /* synthetic */ SfxHandler(SoundEffectsHelper r1, SoundEffectsHelperIA r2) {
            this(r1);
        }

        private SfxHandler(SoundEffectsHelper r1) {
            this.this$0 = r1;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 0: goto L10;
                case 1: goto L9;
                case 2: goto L8;
                case 3: goto L6;
                default: goto L16;
            };
        L8:
            final int effect = msg.arg1;
            final int volume = msg.arg2;
            SoundEffectsHelper.m2208$$Nest$monLoadSoundEffects(this.this$0, new AnonymousClass1(this, effect, volume));
            return;
        L9:
            this.this$0.onUnloadSoundEffects();
            return;
        L10:
            SoundEffectsHelper.m2208$$Nest$monLoadSoundEffects(this.this$0, (OnEffectsLoadCompleteHandler) msg.obj);
            return;
        L16:
            return;
        L6:
            if (SoundEffectsHelper.m2202$$Nest$fgetmSoundPoolLoader(this.this$0) == null) goto L12;
            SoundEffectsHelper.m2202$$Nest$fgetmSoundPoolLoader(this.this$0).onTimeout();
            return;
        }
    }

    private class SfxWorker extends Thread {
        final /* synthetic */ SoundEffectsHelper this$0;

        SfxWorker(SoundEffectsHelper r1) {
            this.this$0 = r1;
            super("AS.SfxWorker");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            SoundEffectsHelper r0 = this.this$0;
            monitor-enter(r0);
            SoundEffectsHelper.m2203$$Nest$fputmSfxHandler(this.this$0, new SfxHandler(this.this$0, null));     // Catch: Throwable -> L8
            this.this$0.notify();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            Looper.loop();
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    private class SoundPoolLoader implements SoundPool.OnLoadCompleteListener {
        private List<OnEffectsLoadCompleteHandler> mLoadCompleteHandlers;
        final /* synthetic */ SoundEffectsHelper this$0;

        SoundPoolLoader(SoundEffectsHelper r2) {
            this.this$0 = r2;
            this.mLoadCompleteHandlers = new ArrayList();
            SoundEffectsHelper.m2201$$Nest$fgetmSoundPool(r2).setOnLoadCompleteListener(this);
        }

        void addHandler(OnEffectsLoadCompleteHandler handler) {
            if (handler == null) goto L5;
            this.mLoadCompleteHandlers.add(handler);
            return;
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
            if (status != 0) goto L21;
            int remainingToLoad = 0;
            Iterator r2 = SoundEffectsHelper.m2200$$Nest$fgetmResources(this.this$0).iterator();
        L6:
            if (r2.hasNext() == false) goto L18;
            Resource res = (Resource) r2.next();
            if (res.mSampleId != sampleId) goto L13;
            if (res.mLoaded == true) goto L13;
            SoundEffectsHelper.m2207$$Nest$mlogEvent(this.this$0, "effect " + res.mFileName + " loaded");
            res.mLoaded = true;
        L13:
            if (res.mSampleId == 0) goto L6;
            if (res.mLoaded == true) goto L6;
            remainingToLoad = remainingToLoad + 1;
            goto L6
        L18:
            if (remainingToLoad != 0) goto L35;
            onComplete(true);
            return;
        L35:
            return;
        L21:
            Resource res2 = SoundEffectsHelper.m2205$$Nest$mfindResourceBySampleId(this.this$0, sampleId);
            if (res2 == null) goto L24;
            String filePath = SoundEffectsHelper.m2206$$Nest$mgetResourceFilePath(this.this$0, res2);
        L25:
            SoundEffectsHelper.m2207$$Nest$mlogEvent(this.this$0, "effect " + filePath + " loading failed, status " + status);
            Log.w(SoundEffectsHelper.TAG, "onLoadSoundEffects(), Error " + status + " while loading sample " + filePath);
            onComplete(false);
            return;
        L24:
            filePath = "with unknown sample ID " + sampleId;
            goto L25
        }

        void onTimeout() {
            onComplete(false);
        }

        void onComplete(boolean success) {
            if (SoundEffectsHelper.m2201$$Nest$fgetmSoundPool(this.this$0) == null) goto L5;
            SoundEffectsHelper.m2201$$Nest$fgetmSoundPool(this.this$0).setOnLoadCompleteListener(null);
        L5:
            Iterator<OnEffectsLoadCompleteHandler> r0 = this.mLoadCompleteHandlers.iterator();
        L7:
            if (r0.hasNext() == false) goto L9;
            OnEffectsLoadCompleteHandler handler = r0.next();
            handler.run(success);
            goto L7
        L9:
            SoundEffectsHelper r1 = this.this$0;
            StringBuilder r2 = new StringBuilder();
            r2.append("effects loading ");
            if (success == false) goto L12;
            String r3 = "completed";
        L13:
            r2.append(r3);
            SoundEffectsHelper.m2207$$Nest$mlogEvent(r1, r2.toString());
            return;
        L12:
            r3 = "failed";
            goto L13
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmResources, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m2200$$Nest$fgetmResources(SoundEffectsHelper r0) {
        return r0.mResources;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSoundPool, reason: not valid java name */
    static /* bridge */ /* synthetic */ SoundPool m2201$$Nest$fgetmSoundPool(SoundEffectsHelper r0) {
        return r0.mSoundPool;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSoundPoolLoader, reason: not valid java name */
    static /* bridge */ /* synthetic */ SoundPoolLoader m2202$$Nest$fgetmSoundPoolLoader(SoundEffectsHelper r0) {
        return r0.mSoundPoolLoader;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmSfxHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2203$$Nest$fputmSfxHandler(SoundEffectsHelper r0, SfxHandler r1) {
        r0.mSfxHandler = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmSoundPoolLoader, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2204$$Nest$fputmSoundPoolLoader(SoundEffectsHelper r0, SoundPoolLoader r1) {
        r0.mSoundPoolLoader = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mfindResourceBySampleId, reason: not valid java name */
    static /* bridge */ /* synthetic */ Resource m2205$$Nest$mfindResourceBySampleId(SoundEffectsHelper r0, int r1) {
        return r0.findResourceBySampleId(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetResourceFilePath, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m2206$$Nest$mgetResourceFilePath(SoundEffectsHelper r0, Resource r1) {
        return r0.getResourceFilePath(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mlogEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2207$$Nest$mlogEvent(SoundEffectsHelper r0, String r1) {
        r0.logEvent(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monLoadSoundEffects, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2208$$Nest$monLoadSoundEffects(SoundEffectsHelper r0, OnEffectsLoadCompleteHandler r1) {
        r0.onLoadSoundEffects(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smcleanupPlayer, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2209$$Nest$smcleanupPlayer(MediaPlayer r0) {
        cleanupPlayer(r0);
    }

    SoundEffectsHelper(Context context, Consumer<PlayerBase> playerAvailableCb) {
        this.mSfxLogger = new EventLogger(26, "Sound Effects Loading");
        this.mResources = new ArrayList();
        this.mEffects = new int[16];
        this.mContext = context;
        this.mSfxAttenuationDb = this.mContext.getResources().getInteger(R.integer.config_vibrationPipelineMaxDuration);
        this.mPlayerAvailableCb = playerAvailableCb;
        startWorker();
    }

    void loadSoundEffects(OnEffectsLoadCompleteHandler onComplete) {
        sendMsg(0, 0, 0, onComplete, 0);
    }

    void unloadSoundEffects() {
        sendMsg(1, 0, 0, null, 0);
    }

    void playSoundEffect(int effect, int volume) {
        sendMsg(2, effect, volume, null, 0);
    }

    void dump(PrintWriter pw, String prefix) {
        if (this.mSfxHandler == null) goto L5;
        pw.println(prefix + "Message handler (watch for unhandled messages):");
        this.mSfxHandler.dump(new PrintWriterPrinter(pw), "  ");
    L6:
        pw.println(prefix + "Default attenuation (dB): " + this.mSfxAttenuationDb);
        this.mSfxLogger.dump(pw);
        return;
    L5:
        pw.println(prefix + "Message handler is null");
        goto L6
    }

    private void startWorker() {
        this.mSfxWorker = new SfxWorker(this);
        this.mSfxWorker.start();
        monitor-enter(this);
    L16:
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mSfxHandler != null) goto L12;
        wait();     // Catch: Throwable -> L8 InterruptedException -> L10
    L11:
        Log.w(TAG, "Interrupted while waiting " + this.mSfxWorker.getName() + " to start");     // Catch: Throwable -> L8
        goto L16
    L12:
        monitor-exit(this);     // Catch: Throwable -> L8
    }

    private void sendMsg(int msg, int arg1, int arg2, Object obj, int delayMs) {
        this.mSfxHandler.sendMessageDelayed(this.mSfxHandler.obtainMessage(msg, arg1, arg2, obj), delayMs);
    }

    private void logEvent(String msg) {
        this.mSfxLogger.enqueue(new EventLogger.StringEvent(msg));
    }

    private void onLoadSoundEffects(OnEffectsLoadCompleteHandler onComplete) {
        if (this.mSoundPoolLoader == null) goto L7;
        this.mSoundPoolLoader.addHandler(onComplete);
        return;
    L7:
        if (this.mSoundPool == null) goto L11;
        if (onComplete == null) goto L29;
        onComplete.run(true);
        return;
    L29:
        return;
    L11:
        logEvent("effects loading started");
        this.mSoundPool = new SoundPool.Builder().setMaxStreams(4).setAudioAttributes(new AudioAttributes.Builder().setUsage(13).setContentType(4).build()).build();
        this.mPlayerAvailableCb.accept(this.mSoundPool);
        loadSoundAssets();
        this.mSoundPoolLoader = new SoundPoolLoader(this);
        this.mSoundPoolLoader.addHandler(new AnonymousClass1(this));
        this.mSoundPoolLoader.addHandler(onComplete);
        int resourcesToLoad = 0;
        Iterator<Resource> r2 = this.mResources.iterator();
    L13:
        if (r2.hasNext() == false) goto L19;
        Resource res = r2.next();
        String filePath = getResourceFilePath(res);
        int sampleId = this.mSoundPool.load(filePath, 0);
        if (sampleId > 0) goto L16;
        logEvent("effect " + filePath + " rejected by SoundPool");
        StringBuilder r6 = new StringBuilder();
        r6.append("SoundPool could not load file: ");
        r6.append(filePath);
        Log.w(TAG, r6.toString());
        goto L13
    L16:
        res.mSampleId = sampleId;
        res.mLoaded = false;
        resourcesToLoad = resourcesToLoad + 1;
        goto L13
    L19:
        if (resourcesToLoad <= 0) goto L21;
        sendMsg(3, 0, 0, null, 15000);
        return;
    L21:
        logEvent("effects loading completed, no effects to load");
        this.mSoundPoolLoader.onComplete(true);
    }

    void onUnloadSoundEffects() {
        if (this.mSoundPool != null) goto L6;
        return;
    L6:
        if (this.mSoundPoolLoader == null) goto L8;
        this.mSoundPoolLoader.addHandler(new AnonymousClass2(this));
    L8:
        logEvent("effects unloading started");
        Iterator<Resource> r0 = this.mResources.iterator();
    L10:
        if (r0.hasNext() == false) goto L15;
        Resource res = r0.next();
        if (res.mSampleId == 0) goto L10;
        this.mSoundPool.unload(res.mSampleId);
        res.unload();
        goto L10
    L15:
        this.mSoundPool.release();
        this.mSoundPool = null;
        logEvent("effects unloading completed");
    }

    void onPlaySoundEffect(int effect, int volume) {
        if (volume >= 0) goto L5;
        float volFloat = (float) Math.pow(10.0d, this.mSfxAttenuationDb / 20.0f);
    L6:
        Resource res = this.mResources.get(this.mEffects[effect]);
        if (this.mSoundPool != null) goto L9;
    L13:
        MediaPlayer mediaPlayer = new MediaPlayer();
        String filePath = getResourceFilePath(res);     // Catch: IllegalStateException -> L16 IllegalArgumentException -> L18 IOException -> L20
        mediaPlayer.setDataSource(filePath);     // Catch: IllegalStateException -> L16 IllegalArgumentException -> L18 IOException -> L20
        mediaPlayer.setAudioStreamType(1);     // Catch: IllegalStateException -> L16 IllegalArgumentException -> L18 IOException -> L20
        mediaPlayer.prepare();     // Catch: IllegalStateException -> L16 IllegalArgumentException -> L18 IOException -> L20
        mediaPlayer.setVolume(volFloat);     // Catch: IllegalStateException -> L16 IllegalArgumentException -> L18 IOException -> L20
        mediaPlayer.setOnCompletionListener(new AnonymousClass3(this));     // Catch: IllegalStateException -> L16 IllegalArgumentException -> L18 IOException -> L20
        mediaPlayer.setOnErrorListener(new AnonymousClass4(this));     // Catch: IllegalStateException -> L16 IllegalArgumentException -> L18 IOException -> L20
        mediaPlayer.start();     // Catch: IllegalStateException -> L16 IllegalArgumentException -> L18 IOException -> L20
    L29:
        return;
    L20:
        ex = move-exception;
        Log.w(TAG, "MediaPlayer IOException: " + ex);
        return;
    L18:
        ex = move-exception;
        Log.w(TAG, "MediaPlayer IllegalArgumentException: " + ex);
        return;
    L16:
        ex = move-exception;
        Log.w(TAG, "MediaPlayer IllegalStateException: " + ex);
        return;
    L9:
        if (res.mSampleId == 0) goto L13;
        if (res.mLoaded == false) goto L13;
        this.mSoundPool.play(res.mSampleId, volFloat, volFloat, 0, 0, 1.0f);
        return;
    L5:
        float volFloat2 = volume;
        volFloat = volFloat2 / 1000.0f;
        goto L6
    }

    private static void cleanupPlayer(MediaPlayer mp) {
        if (mp == null) goto L10;
        mp.stop();     // Catch: IllegalStateException -> L5
        mp.release();     // Catch: IllegalStateException -> L5
        return;
    L5:
        ex = move-exception;
        Log.w(TAG, "MediaPlayer IllegalStateException: " + ex);
        return;
    }

    private String getResourceFilePath(Resource res) {
        String filePath = Environment.getProductDirectory() + SOUND_EFFECTS_PATH + res.mFileName;
        if (new File(filePath).isFile() == false) goto L5;
        return filePath;
    L5:
        return Environment.getRootDirectory() + SOUND_EFFECTS_PATH + res.mFileName;
    }

    private void loadSoundAssetDefaults() {
        int defaultResourceIdx = this.mResources.size();
        this.mResources.add(new Resource("Effect_Tick.ogg"));
        Arrays.fill(this.mEffects, defaultResourceIdx);
    }

    private void loadSoundAssets() {
        XmlResourceParser parser = null;
        if (this.mResources.isEmpty() == true) goto L5;
        return;
    L5:
        loadSoundAssetDefaults();
        parser = this.mContext.getResources().getXml(R.xml.audio_assets);     // Catch: Throwable -> L16 IOException -> L18 XmlPullParserException -> L20 Resources.NotFoundException -> L22
        XmlUtils.beginDocument(parser, TAG_AUDIO_ASSETS);     // Catch: Throwable -> L16 IOException -> L18 XmlPullParserException -> L20 Resources.NotFoundException -> L22
        String version = parser.getAttributeValue(null, ATTR_VERSION);     // Catch: Throwable -> L16 IOException -> L18 XmlPullParserException -> L20 Resources.NotFoundException -> L22
        Map<Integer, Integer> parserCounter = new HashMap();     // Catch: Throwable -> L16 IOException -> L18 XmlPullParserException -> L20 Resources.NotFoundException -> L22
        if (ASSET_FILE_VERSION.equals(version) == false) goto L49;
    L8:
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L16 IOException -> L18 XmlPullParserException -> L20 Resources.NotFoundException -> L22
        String element = parser.getName();     // Catch: Throwable -> L16 IOException -> L18 XmlPullParserException -> L20 Resources.NotFoundException -> L22
        boolean homeSoundParsed = false;
        if (element == null) goto L36;
        if (element.equals(TAG_GROUP) == true) goto L13;
        if (element.equals(TAG_ASSET) == false) goto L36;
        String id = parser.getAttributeValue(null, ATTR_ASSET_ID);     // Catch: Throwable -> L16 IOException -> L18 XmlPullParserException -> L20 Resources.NotFoundException -> L22
        String file = parser.getAttributeValue(null, ATTR_ASSET_FILE);     // Catch: Throwable -> L16 IOException -> L18 XmlPullParserException -> L20 Resources.NotFoundException -> L22
        Field field = AudioManager.class.getField(id);     // Catch: Throwable -> L16 Exception -> L34
        int fx = field.getInt(null);     // Catch: Throwable -> L16 Exception -> L34
        int currentParserCount = parserCounter.getOrDefault(Integer.valueOf(fx), 0).intValue() + 1;     // Catch: Throwable -> L16 IOException -> L18 XmlPullParserException -> L20 Resources.NotFoundException -> L22
        parserCounter.put(Integer.valueOf(fx), Integer.valueOf(currentParserCount));     // Catch: Throwable -> L16 IOException -> L18 XmlPullParserException -> L20 Resources.NotFoundException -> L22
        if (currentParserCount <= 1) goto L32;
        Log.w(TAG, "Duplicate definition for sound ID: " + id);     // Catch: Throwable -> L16 IOException -> L18 XmlPullParserException -> L20 Resources.NotFoundException -> L22
    L32:
        this.mEffects[fx] = findOrAddResourceByFileName(file);     // Catch: Throwable -> L16 IOException -> L18 XmlPullParserException -> L20 Resources.NotFoundException -> L22
    L35:
        Log.w(TAG, "Invalid sound ID: " + id);     // Catch: Throwable -> L16 IOException -> L18 XmlPullParserException -> L20 Resources.NotFoundException -> L22
        goto L8
    L13:
        String name = parser.getAttributeValue(null, "name");     // Catch: Throwable -> L16 IOException -> L18 XmlPullParserException -> L20 Resources.NotFoundException -> L22
        if (GROUP_TOUCH_SOUNDS.equals(name) == true) goto L8;
        Log.w(TAG, "Unsupported group name: " + name);     // Catch: Throwable -> L16 IOException -> L18 XmlPullParserException -> L20 Resources.NotFoundException -> L22
    L36:
        boolean navigationRepeatFxParsed = allNavigationRepeatSoundsParsed(parserCounter);     // Catch: Throwable -> L16 IOException -> L18 XmlPullParserException -> L20 Resources.NotFoundException -> L22
        if (parserCounter.getOrDefault(11, 0).intValue() <= 0) goto L39;
        homeSoundParsed = true;
    L39:
        if (navigationRepeatFxParsed == true) goto L41;
        if (homeSoundParsed == false) goto L49;
    L41:
        AudioManager audioManager = (AudioManager) this.mContext.getSystemService(AudioManager.class);     // Catch: Throwable -> L16 IOException -> L18 XmlPullParserException -> L20 Resources.NotFoundException -> L22
        if (audioManager == null) goto L45;
        if (navigationRepeatFxParsed == false) goto L45;
        audioManager.setNavigationRepeatSoundEffectsEnabled(true);     // Catch: Throwable -> L16 IOException -> L18 XmlPullParserException -> L20 Resources.NotFoundException -> L22
    L45:
        if (audioManager == null) goto L49;
        if (homeSoundParsed == false) goto L49;
        audioManager.setHomeSoundEffectEnabled(true);     // Catch: Throwable -> L16 IOException -> L18 XmlPullParserException -> L20 Resources.NotFoundException -> L22
    L49:
        parser.close();
        return;
    L16:
        th = move-exception;
        if (parser == null) goto L63;
        parser.close();
    L63:
        throw th;
    L22:
        e = move-exception;
        Log.w(TAG, "audio assets file not found", e);     // Catch: Throwable -> L16
        if (parser != null) goto L49;
        return;
    L18:
        e = move-exception;
        Log.w(TAG, "I/O exception reading sound assets", e);     // Catch: Throwable -> L16
        if (parser != null) goto L49;
        return;
    L20:
        e = move-exception;
        Log.w(TAG, "XML parser exception reading sound assets", e);     // Catch: Throwable -> L16
        if (parser != null) goto L49;
    }

    private boolean allNavigationRepeatSoundsParsed(Map<Integer, Integer> parserCounter) {
        int numFastScrollSoundEffectsParsed = ((parserCounter.getOrDefault(12, 0).intValue() + parserCounter.getOrDefault(13, 0).intValue()) + parserCounter.getOrDefault(14, 0).intValue()) + parserCounter.getOrDefault(15, 0).intValue();
        if (numFastScrollSoundEffectsParsed != 4) goto L6;
        return true;
    L6:
        return false;
    }

    private int findOrAddResourceByFileName(String fileName) {
        int i = 0;
    L4:
        if (i >= this.mResources.size()) goto L9;
        if (this.mResources.get(i).mFileName.equals(fileName) == true) goto L7;
        i = i + 1;
        goto L4
    L7:
        return i;
    L9:
        int result = this.mResources.size();
        this.mResources.add(new Resource(fileName));
        return result;
    }

    private Resource findResourceBySampleId(int sampleId) {
        Iterator<Resource> r0 = this.mResources.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Resource res = r0.next();
        if (res.mSampleId != sampleId) goto L4;
        return res;
    L9:
        return null;
    }
}
