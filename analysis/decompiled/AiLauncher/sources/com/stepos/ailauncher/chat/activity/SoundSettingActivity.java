package com.stepos.ailauncher.chat.activity;

import Ua.C1060i;
import Z8.C1173v;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.C1398p;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.adapter.VoiceChoiceItem;
import com.stepos.ailauncher.chat.api.SystemVoicesResponse;
import com.stepos.ailauncher.chat.api.VoiceDetail;
import com.stepos.ailauncher.chat.view.C2940q8;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import z5.ActivityC6361a;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 G2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0013\u001a\u00020\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0003J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0019\u0010\u0017J\u000f\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u0003J\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\fH\u0002¢\u0006\u0004\b!\u0010\"J%\u0010$\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010#\u001a\u00020\fH\u0002¢\u0006\u0004\b$\u0010%J\u0019\u0010(\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010&H\u0014¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0004H\u0014¢\u0006\u0004\b*\u0010\u0003J\u000f\u0010+\u001a\u00020\u0004H\u0014¢\u0006\u0004\b+\u0010\u0003J\u000f\u0010,\u001a\u00020\u0004H\u0014¢\u0006\u0004\b,\u0010\u0003R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u00109\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010;\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010\u0010R\u0018\u0010?\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010B\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010E\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006I"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/SoundSettingActivity;", "Lz5/a;", "<init>", "()V", "LY8/t;", "H", "Lcom/stepos/ailauncher/chat/api/SystemVoicesResponse;", "resp", "", "Lcom/stepos/ailauncher/chat/adapter/r0;", "F", "(Lcom/stepos/ailauncher/chat/api/SystemVoicesResponse;)Ljava/util/List;", "", "name", "description", "Lkotlin/Pair;", "I", "(Ljava/lang/String;Ljava/lang/String;)Lkotlin/Pair;", DidiCardProvider.KEY_ITEMS, "L", "(Ljava/util/List;)Ljava/lang/String;", "item", "K", "(Lcom/stepos/ailauncher/chat/adapter/r0;)V", "G", "N", ExifInterface.LONGITUDE_WEST, "Landroid/media/MediaPlayer;", "mp", ExifInterface.LATITUDE_SOUTH, "(Landroid/media/MediaPlayer;)V", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "message", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;)V", "selectedId", "U", "(Ljava/util/List;Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "onPause", "onDestroy", "Landroidx/recyclerview/widget/RecyclerView;", "rvVoiceList", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/widget/ProgressBar;", "pbLoading", "Landroid/widget/ProgressBar;", "Landroid/widget/TextView;", "tvErrorState", "Landroid/widget/TextView;", "Lcom/stepos/ailauncher/chat/adapter/q0;", "adapter", "Lcom/stepos/ailauncher/chat/adapter/q0;", "demoPlayer", "Landroid/media/MediaPlayer;", "playingVoiceId", "Ljava/lang/String;", "", "playGeneration", "pendingPlay", "Lcom/stepos/ailauncher/chat/adapter/r0;", "Ljava/util/concurrent/ExecutorService;", "releaseExecutor", "Ljava/util/concurrent/ExecutorService;", "Ljava/lang/Runnable;", "playDebounceRunnable", "Ljava/lang/Runnable;", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SoundSettingActivity extends ActivityC6361a {
    public static final String KEY_SELECTED_VOICE_ID = "voice_setting_selected_voice_id";
    public static final String KEY_SELECTED_VOICE_NAME = "voice_setting_selected_voice_name";
    private static final long PLAY_DEBOUNCE_MS = 300;
    private static final String TAG = "SoundSettingActivity";
    private final com.stepos.ailauncher.chat.adapter.q0 adapter = new com.stepos.ailauncher.chat.adapter.q0(null, new SoundSettingActivity$adapter$1(this), 1, 0 == true ? 1 : 0);
    private MediaPlayer demoPlayer;
    private ProgressBar pbLoading;
    private VoiceChoiceItem pendingPlay;
    private final Runnable playDebounceRunnable;
    private int playGeneration;
    private String playingVoiceId;
    private final ExecutorService releaseExecutor;
    private RecyclerView rvVoiceList;
    private TextView tvErrorState;

    /* JADX WARN: Multi-variable type inference failed */
    public SoundSettingActivity() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.stepos.ailauncher.chat.activity.K1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return SoundSettingActivity.R(runnable);
            }
        });
        kotlin.jvm.internal.p.h(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this.releaseExecutor = executorServiceNewSingleThreadExecutor;
        this.playDebounceRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.activity.L1
            @Override // java.lang.Runnable
            public final void run() throws IllegalArgumentException {
                SoundSettingActivity.M(this.f24744a);
            }
        };
    }

    public static final void J(SoundSettingActivity soundSettingActivity, View view) {
        soundSettingActivity.H();
    }

    public static final void M(SoundSettingActivity soundSettingActivity) throws IllegalArgumentException {
        VoiceChoiceItem voiceChoiceItem = soundSettingActivity.pendingPlay;
        if (voiceChoiceItem == null) {
            return;
        }
        soundSettingActivity.pendingPlay = null;
        soundSettingActivity.N(voiceChoiceItem);
    }

    public static final void O(int i10, SoundSettingActivity soundSettingActivity, MediaPlayer mediaPlayer, MediaPlayer mediaPlayer2) {
        Object objB;
        if (i10 != soundSettingActivity.playGeneration) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            mediaPlayer2.start();
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "demo start failed", thE, false, 8, null);
        }
    }

    public static final void P(int i10, SoundSettingActivity soundSettingActivity, MediaPlayer mediaPlayer) {
        if (i10 != soundSettingActivity.playGeneration) {
            return;
        }
        soundSettingActivity.W();
    }

    public static final boolean Q(String str, int i10, SoundSettingActivity soundSettingActivity, MediaPlayer mediaPlayer, int i11, int i12) {
        C4148a.u(TAG, "demo playback error what=" + i11 + " extra=" + i12 + " url=" + str, false, 4, null);
        if (i10 != soundSettingActivity.playGeneration) {
            return true;
        }
        soundSettingActivity.W();
        return true;
    }

    public static final Thread R(Runnable runnable) {
        Thread thread = new Thread(runnable, "sound-demo-release");
        thread.setDaemon(true);
        return thread;
    }

    public static final void X(SoundSettingActivity soundSettingActivity, MediaPlayer mediaPlayer) {
        soundSettingActivity.S(mediaPlayer);
    }

    public static final void Y(SoundSettingActivity soundSettingActivity, MediaPlayer mediaPlayer) {
        soundSettingActivity.S(mediaPlayer);
    }

    public final List<VoiceChoiceItem> F(SystemVoicesResponse resp) {
        String string;
        String str;
        List<String> voices = resp.getVoices();
        if (voices == null) {
            voices = C1173v.m();
        }
        Map<String, VoiceDetail> voicesDetails = resp.getVoicesDetails();
        if (voicesDetails == null) {
            voicesDetails = kotlin.collections.a.i();
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : voices) {
            VoiceDetail voiceDetail = voicesDetails.get(str2);
            if (voiceDetail != null) {
                String voiceName = voiceDetail.getVoiceName();
                String string2 = voiceName != null ? La.H.D1(voiceName).toString() : null;
                if (string2 == null) {
                    string2 = "";
                }
                String voiceDescription = voiceDetail.getVoiceDescription();
                Pair<String, String> pairI = I(string2, voiceDescription != null ? La.H.D1(voiceDescription).toString() : null);
                String strA = pairI.a();
                String strB = pairI.b();
                if (strA.length() != 0) {
                    String imgUrl = voiceDetail.getImgUrl();
                    String string3 = imgUrl != null ? La.H.D1(imgUrl).toString() : null;
                    String voiceDemoUrl = voiceDetail.getVoiceDemoUrl();
                    if (voiceDemoUrl != null) {
                        str = string3;
                        string = La.H.D1(voiceDemoUrl).toString();
                    } else {
                        String str3 = string3;
                        string = null;
                        str = str3;
                    }
                    arrayList.add(new VoiceChoiceItem(str2, strA, strB, str, string));
                }
            }
        }
        return arrayList;
    }

    public final void G() {
        RecyclerView recyclerView = null;
        this.pendingPlay = null;
        RecyclerView recyclerView2 = this.rvVoiceList;
        if (recyclerView2 != null) {
            if (recyclerView2 == null) {
                kotlin.jvm.internal.p.A("rvVoiceList");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.removeCallbacks(this.playDebounceRunnable);
        }
    }

    public final void H() {
        V();
        C1060i.d(C1398p.a(this), null, null, new SoundSettingActivity$loadVoices$1(this, null), 3, null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public final Pair<String, String> I(String name, String description) {
        if (!kotlin.jvm.internal.p.d(getResources().getConfiguration().getLocales().get(0).getLanguage(), Locale.ENGLISH.getLanguage())) {
            return Y8.j.a(name, description);
        }
        Locale ROOT = Locale.ROOT;
        kotlin.jvm.internal.p.h(ROOT, "ROOT");
        String lowerCase = name.toLowerCase(ROOT);
        kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case 2998028:
                if (lowerCase.equals(DidiCardProvider.MARKET_SOURCE)) {
                    return Y8.j.a(name, getString(R$string.sound_voice_amoo_description));
                }
                break;
            case 647084659:
                if (lowerCase.equals("元气少女")) {
                    String string = getString(R$string.sound_voice_energetic_girl_name);
                    kotlin.jvm.internal.p.h(string, "getString(...)");
                    return Y8.j.a(string, getString(R$string.sound_voice_energetic_girl_description));
                }
                break;
            case 806138367:
                if (lowerCase.equals("播音男声")) {
                    String string2 = getString(R$string.sound_voice_broadcast_male_name);
                    kotlin.jvm.internal.p.h(string2, "getString(...)");
                    return Y8.j.a(string2, getString(R$string.sound_voice_broadcast_male_description));
                }
                break;
            case 945537183:
                if (lowerCase.equals("磁性男声")) {
                    String string3 = getString(R$string.sound_voice_magnetic_male_name);
                    kotlin.jvm.internal.p.h(string3, "getString(...)");
                    return Y8.j.a(string3, getString(R$string.sound_voice_magnetic_male_description));
                }
                break;
        }
        return Y8.j.a(name, description);
    }

    public final void K(VoiceChoiceItem item) throws IllegalArgumentException {
        com.stepos.ailauncher.chat.manager.U0 u02 = com.stepos.ailauncher.chat.manager.U0.INSTANCE;
        u02.C(item.getVoiceId(), item.getName());
        u02.d(this);
        this.adapter.i(item.getVoiceId());
        if (kotlin.jvm.internal.p.d(this.playingVoiceId, item.getVoiceId()) && this.demoPlayer != null) {
            G();
            W();
            return;
        }
        this.pendingPlay = item;
        RecyclerView recyclerView = this.rvVoiceList;
        if (recyclerView == null) {
            N(item);
            return;
        }
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            kotlin.jvm.internal.p.A("rvVoiceList");
            recyclerView = null;
        }
        recyclerView.removeCallbacks(this.playDebounceRunnable);
        RecyclerView recyclerView3 = this.rvVoiceList;
        if (recyclerView3 == null) {
            kotlin.jvm.internal.p.A("rvVoiceList");
        } else {
            recyclerView2 = recyclerView3;
        }
        recyclerView2.postDelayed(this.playDebounceRunnable, 300L);
    }

    public final String L(List<VoiceChoiceItem> items) {
        String strJ = com.stepos.ailauncher.chat.manager.U0.INSTANCE.j();
        if (strJ.length() > 0) {
            List<VoiceChoiceItem> list = items;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (kotlin.jvm.internal.p.d(((VoiceChoiceItem) it.next()).getVoiceId(), strJ)) {
                        return strJ;
                    }
                }
            }
        }
        return ((VoiceChoiceItem) Z8.F.q0(items)).getVoiceId();
    }

    public final void N(VoiceChoiceItem item) throws IllegalArgumentException {
        Object objB;
        final String demoUrl = item.getDemoUrl();
        if (demoUrl == null || La.H.x0(demoUrl)) {
            W();
            return;
        }
        W();
        final int i10 = this.playGeneration + 1;
        this.playGeneration = i10;
        this.playingVoiceId = item.getVoiceId();
        final MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build());
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.stepos.ailauncher.chat.activity.M1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer2) {
                SoundSettingActivity.O(i10, this, mediaPlayer, mediaPlayer2);
            }
        });
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.stepos.ailauncher.chat.activity.N1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer2) {
                SoundSettingActivity.P(i10, this, mediaPlayer2);
            }
        });
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.stepos.ailauncher.chat.activity.O1
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer2, int i11, int i12) {
                return SoundSettingActivity.Q(demoUrl, i10, this, mediaPlayer2, i11, i12);
            }
        });
        try {
            Result.Companion companion = Result.INSTANCE;
            mediaPlayer.setDataSource(demoUrl);
            mediaPlayer.prepareAsync();
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.g(TAG, "demo setDataSource failed url=" + demoUrl, thE, false, 8, null);
            if (i10 == this.playGeneration) {
                W();
            }
        }
        this.demoPlayer = mediaPlayer;
    }

    public final void S(MediaPlayer mp) {
        try {
            Result.Companion companion = Result.INSTANCE;
            mp.stop();
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        try {
            mp.reset();
            Result.b(Y8.t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.b(C4849c.a(th2));
        }
        try {
            mp.release();
            Result.b(Y8.t.f7040a);
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.INSTANCE;
            Result.b(C4849c.a(th3));
        }
    }

    public final void T(String message) {
        ProgressBar progressBar = this.pbLoading;
        RecyclerView recyclerView = null;
        if (progressBar == null) {
            kotlin.jvm.internal.p.A("pbLoading");
            progressBar = null;
        }
        progressBar.setVisibility(8);
        TextView textView = this.tvErrorState;
        if (textView == null) {
            kotlin.jvm.internal.p.A("tvErrorState");
            textView = null;
        }
        textView.setVisibility(0);
        TextView textView2 = this.tvErrorState;
        if (textView2 == null) {
            kotlin.jvm.internal.p.A("tvErrorState");
            textView2 = null;
        }
        textView2.setText(message);
        RecyclerView recyclerView2 = this.rvVoiceList;
        if (recyclerView2 == null) {
            kotlin.jvm.internal.p.A("rvVoiceList");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.setVisibility(8);
    }

    public final void U(List<VoiceChoiceItem> items, String selectedId) {
        ProgressBar progressBar = this.pbLoading;
        if (progressBar == null) {
            kotlin.jvm.internal.p.A("pbLoading");
            progressBar = null;
        }
        progressBar.setVisibility(8);
        TextView textView = this.tvErrorState;
        if (textView == null) {
            kotlin.jvm.internal.p.A("tvErrorState");
            textView = null;
        }
        textView.setVisibility(8);
        RecyclerView recyclerView = this.rvVoiceList;
        if (recyclerView == null) {
            kotlin.jvm.internal.p.A("rvVoiceList");
            recyclerView = null;
        }
        recyclerView.setVisibility(0);
        this.adapter.h(items, selectedId);
        Iterator<VoiceChoiceItem> it = items.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            } else if (kotlin.jvm.internal.p.d(it.next().getVoiceId(), selectedId)) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 > 0) {
            RecyclerView recyclerView2 = this.rvVoiceList;
            if (recyclerView2 == null) {
                kotlin.jvm.internal.p.A("rvVoiceList");
                recyclerView2 = null;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
            LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
            if (linearLayoutManager != null) {
                linearLayoutManager.scrollToPositionWithOffset(i10, 0);
            }
        }
    }

    public final void V() {
        ProgressBar progressBar = this.pbLoading;
        RecyclerView recyclerView = null;
        if (progressBar == null) {
            kotlin.jvm.internal.p.A("pbLoading");
            progressBar = null;
        }
        progressBar.setVisibility(0);
        TextView textView = this.tvErrorState;
        if (textView == null) {
            kotlin.jvm.internal.p.A("tvErrorState");
            textView = null;
        }
        textView.setVisibility(8);
        RecyclerView recyclerView2 = this.rvVoiceList;
        if (recyclerView2 == null) {
            kotlin.jvm.internal.p.A("rvVoiceList");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.setVisibility(8);
    }

    public final void W() {
        this.playGeneration++;
        final MediaPlayer mediaPlayer = this.demoPlayer;
        this.demoPlayer = null;
        this.playingVoiceId = null;
        if (mediaPlayer == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            mediaPlayer.setOnPreparedListener(null);
            mediaPlayer.setOnCompletionListener(null);
            mediaPlayer.setOnErrorListener(null);
            mediaPlayer.setVolume(0.0f, 0.0f);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        if (!this.releaseExecutor.isShutdown()) {
            this.releaseExecutor.execute(new Runnable() { // from class: com.stepos.ailauncher.chat.activity.I1
                @Override // java.lang.Runnable
                public final void run() {
                    SoundSettingActivity.Y(this.f24734a, mediaPlayer);
                }
            });
            return;
        }
        Thread thread = new Thread(new Runnable() { // from class: com.stepos.ailauncher.chat.activity.H1
            @Override // java.lang.Runnable
            public final void run() {
                SoundSettingActivity.X(this.f24731a, mediaPlayer);
            }
        }, "sound-demo-release-fallback");
        thread.setDaemon(true);
        thread.start();
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R$layout.activity_sound_setting);
        C2940q8.d(C2940q8.INSTANCE, this, R$string.sound_setting_title, null, 4, null);
        View viewFindViewById = findViewById(R$id.rvVoiceList);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        this.rvVoiceList = (RecyclerView) viewFindViewById;
        View viewFindViewById2 = findViewById(R$id.pbVoiceLoading);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        this.pbLoading = (ProgressBar) viewFindViewById2;
        View viewFindViewById3 = findViewById(R$id.tvVoiceErrorState);
        kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
        this.tvErrorState = (TextView) viewFindViewById3;
        RecyclerView recyclerView = this.rvVoiceList;
        TextView textView = null;
        if (recyclerView == null) {
            kotlin.jvm.internal.p.A("rvVoiceList");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView recyclerView2 = this.rvVoiceList;
        if (recyclerView2 == null) {
            kotlin.jvm.internal.p.A("rvVoiceList");
            recyclerView2 = null;
        }
        recyclerView2.setAdapter(this.adapter);
        TextView textView2 = this.tvErrorState;
        if (textView2 == null) {
            kotlin.jvm.internal.p.A("tvErrorState");
        } else {
            textView = textView2;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.J1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SoundSettingActivity.J(this.f24739a, view);
            }
        });
        H();
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        G();
        W();
        this.releaseExecutor.shutdown();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onPause() {
        super.onPause();
        G();
        W();
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
