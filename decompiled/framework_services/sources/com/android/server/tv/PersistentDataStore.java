package com.android.server.tv;

import android.content.Context;
import android.content.Intent;
import android.media.tv.TvContentRating;
import android.os.Environment;
import android.os.Handler;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.Xml;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import libcore.io.IoUtils;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
final class PersistentDataStore {
    private static final String ATTR_ENABLED = "enabled";
    private static final String ATTR_STRING = "string";
    private static final String TAG = "TvInputManagerService";
    private static final String TAG_BLOCKED_RATINGS = "blocked-ratings";
    private static final String TAG_PARENTAL_CONTROLS = "parental-controls";
    private static final String TAG_RATING = "rating";
    private static final String TAG_TV_INPUT_MANAGER_STATE = "tv-input-manager-state";
    private final AtomicFile mAtomicFile;
    private final List<TvContentRating> mBlockedRatings;
    private boolean mBlockedRatingsChanged;
    private final Context mContext;
    private final Handler mHandler;
    private boolean mLoaded;
    private boolean mParentalControlsEnabled;
    private boolean mParentalControlsEnabledChanged;
    private final Runnable mSaveRunnable;

    /* JADX INFO: renamed from: -$$Nest$msave, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8725$$Nest$msave(PersistentDataStore r0) {
        r0.save();
    }

    public PersistentDataStore(Context context, int userId) {
        this.mHandler = new Handler();
        this.mBlockedRatings = Collections.synchronizedList(new ArrayList());
        this.mSaveRunnable = new AnonymousClass1(this);
        this.mContext = context;
        File userDir = Environment.getUserSystemDirectory(userId);
        if (userDir.exists() == false) goto L5;
    L9:
        this.mAtomicFile = new AtomicFile(new File(userDir, "tv-input-manager-state.xml"), "tv-input-state");
        return;
    L5:
        if (userDir.mkdirs() == true) goto L9;
        throw new IllegalStateException("User dir cannot be created: " + userDir);
    }

    public boolean isParentalControlsEnabled() {
        loadIfNeeded();
        return this.mParentalControlsEnabled;
    }

    public void setParentalControlsEnabled(boolean enabled) {
        loadIfNeeded();
        if (this.mParentalControlsEnabled == enabled) goto L6;
        this.mParentalControlsEnabled = enabled;
        this.mParentalControlsEnabledChanged = true;
        postSave();
        return;
    }

    public boolean isRatingBlocked(TvContentRating rating) {
        loadIfNeeded();
        List<TvContentRating> r0 = this.mBlockedRatings;
        monitor-enter(r0);
        Iterator<TvContentRating> r1 = this.mBlockedRatings.iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L15;
        TvContentRating blockedRating = r1.next();     // Catch: Throwable -> L12
        if (rating.contains(blockedRating) == false) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L12:
        th = move-exception;
        throw th;
    }

    public TvContentRating[] getBlockedRatings() {
        loadIfNeeded();
        return (TvContentRating[]) this.mBlockedRatings.toArray(new TvContentRating[this.mBlockedRatings.size()]);
    }

    public void addBlockedRating(TvContentRating rating) {
        loadIfNeeded();
        if (rating != null) goto L5;
        return;
    L5:
        if (this.mBlockedRatings.contains(rating) == true) goto L9;
        this.mBlockedRatings.add(rating);
        this.mBlockedRatingsChanged = true;
        postSave();
        return;
    }

    public void removeBlockedRating(TvContentRating rating) {
        loadIfNeeded();
        if (rating != null) goto L5;
        return;
    L5:
        if (this.mBlockedRatings.contains(rating) == false) goto L9;
        this.mBlockedRatings.remove(rating);
        this.mBlockedRatingsChanged = true;
        postSave();
        return;
    }

    private void loadIfNeeded() {
        if (this.mLoaded == true) goto L6;
        load();
        this.mLoaded = true;
        return;
    }

    private void clearState() {
        this.mBlockedRatings.clear();
        this.mParentalControlsEnabled = false;
    }

    private void load() {
        clearState();
        InputStream is = this.mAtomicFile.openRead();     // Catch: FileNotFoundException -> L14
        TypedXmlPullParser parser = Xml.resolvePullParser(is);     // Catch: Throwable -> L6 Throwable -> L8
        loadFromXml(parser);     // Catch: Throwable -> L6 Throwable -> L8
        IoUtils.closeQuietly(is);
    L16:
        return;
    L6:
        th = move-exception;
        IoUtils.closeQuietly(is);
        throw th;
    L8:
        ex = move-exception;
        Slog.w(TAG, "Failed to load tv input manager persistent store data.", ex);     // Catch: Throwable -> L6
        clearState();     // Catch: Throwable -> L6
        IoUtils.closeQuietly(is);
    }

    private void postSave() {
        this.mHandler.removeCallbacks(this.mSaveRunnable);
        this.mHandler.post(this.mSaveRunnable);
    }

    private void save() {
        FileOutputStream os = this.mAtomicFile.startWrite();     // Catch: IOException -> L8
        TypedXmlSerializer serializer = Xml.resolveSerializer(os);     // Catch: Throwable -> L12
        saveToXml(serializer);     // Catch: Throwable -> L12
        serializer.flush();     // Catch: Throwable -> L12
    L6:
        if (1 == 0) goto L10;
        this.mAtomicFile.finishWrite(os);     // Catch: IOException -> L8
        broadcastChangesIfNeeded();     // Catch: IOException -> L8
    L23:
        return;
    L10:
        this.mAtomicFile.failWrite(os);     // Catch: IOException -> L8
    L12:
        th = move-exception;
        if (0 == 0) goto L15;
        this.mAtomicFile.finishWrite(os);     // Catch: IOException -> L8
        broadcastChangesIfNeeded();     // Catch: IOException -> L8
    L17:
        throw th;     // Catch: IOException -> L8
    L15:
        this.mAtomicFile.failWrite(os);     // Catch: IOException -> L8
    L8:
        ex = move-exception;
        Slog.w(TAG, "Failed to save tv input manager persistent store data.", ex);
    }

    private void broadcastChangesIfNeeded() {
        if (this.mParentalControlsEnabledChanged == false) goto L6;
        this.mParentalControlsEnabledChanged = false;
        this.mContext.sendBroadcastAsUser(new Intent("android.media.tv.action.PARENTAL_CONTROLS_ENABLED_CHANGED"), UserHandle.ALL);
    L6:
        if (this.mBlockedRatingsChanged == false) goto L9;
        this.mBlockedRatingsChanged = false;
        this.mContext.sendBroadcastAsUser(new Intent("android.media.tv.action.BLOCKED_RATINGS_CHANGED"), UserHandle.ALL);
        return;
    }

    private void loadFromXml(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
        XmlUtils.beginDocument(parser, TAG_TV_INPUT_MANAGER_STATE);
        int outerDepth = parser.getDepth();
    L4:
        if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L11;
        if (parser.getName().equals(TAG_BLOCKED_RATINGS) == true) goto L7;
        if (parser.getName().equals(TAG_PARENTAL_CONTROLS) == false) goto L4;
        this.mParentalControlsEnabled = parser.getAttributeBoolean(null, "enabled");
        goto L4
    L7:
        loadBlockedRatingsFromXml(parser);
        goto L4
    }

    private void loadBlockedRatingsFromXml(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
        int outerDepth = parser.getDepth();
    L4:
        if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L12;
        if (parser.getName().equals(TAG_RATING) == false) goto L4;
        String ratingString = parser.getAttributeValue(null, ATTR_STRING);
        if (TextUtils.isEmpty(ratingString) == true) goto L11;
        this.mBlockedRatings.add(TvContentRating.unflattenFromString(ratingString));
        goto L4
    L11:
        throw new XmlPullParserException("Missing string attribute on rating");
    }

    private void saveToXml(TypedXmlSerializer serializer) throws IOException {
        serializer.startDocument(null, true);
        serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        serializer.startTag(null, TAG_TV_INPUT_MANAGER_STATE);
        serializer.startTag(null, TAG_BLOCKED_RATINGS);
        List<TvContentRating> r0 = this.mBlockedRatings;
        monitor-enter(r0);
        Iterator<TvContentRating> r1 = this.mBlockedRatings.iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        TvContentRating rating = r1.next();     // Catch: Throwable -> L8
        serializer.startTag(null, TAG_RATING);     // Catch: Throwable -> L8
        serializer.attribute(null, ATTR_STRING, rating.flattenToString());     // Catch: Throwable -> L8
        serializer.endTag(null, TAG_RATING);     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        serializer.endTag(null, TAG_BLOCKED_RATINGS);
        serializer.startTag(null, TAG_PARENTAL_CONTROLS);
        serializer.attributeBoolean(null, "enabled", this.mParentalControlsEnabled);
        serializer.endTag(null, TAG_PARENTAL_CONTROLS);
        serializer.endTag(null, TAG_TV_INPUT_MANAGER_STATE);
        serializer.endDocument();
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
