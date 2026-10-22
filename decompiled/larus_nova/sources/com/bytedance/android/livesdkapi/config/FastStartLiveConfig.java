package com.bytedance.android.livesdkapi.config;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\t\u0018\u0000 62\u00020\u0001:\u000267B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001dR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0005\"\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007R\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0005\"\u0004\b\u000f\u0010\u0007R\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0005\"\u0004\b\u0011\u0010\u0007R\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R.\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R \u0010(\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b)\u0010\u0002\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010/X\u0086\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00068"}, d2 = {"Lcom/bytedance/android/livesdkapi/config/FastStartLiveConfig;", "Ljava/io/Serializable;", "()V", "isAutoEnterBroadcast", "", "()Z", "setAutoEnterBroadcast", "(Z)V", "isAutoFinishOnLiveStarted", "setAutoFinishOnLiveStarted", "isNeeVcdAuthorize", "setNeeVcdAuthorize", "isNeedVerify", "setNeedVerify", "isPreInitCreateInfo", "setPreInitCreateInfo", "isPreInitUserPermission", "setPreInitUserPermission", "isTransparentPageForSchema", "setTransparentPageForSchema", "liveMode", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "getLiveMode", "()Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "setLiveMode", "(Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;)V", Keys.API_EVENT_KEY_PLAY_MODE, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getPlayMode", "()Ljava/util/ArrayList;", "setPlayMode", "(Ljava/util/ArrayList;)V", "sourcePrams", "", "getSourcePrams", "()Ljava/lang/String;", "setSourcePrams", "(Ljava/lang/String;)V", "startType", "getStartType$annotations", "getStartType", "()I", "setStartType", "(I)V", "targetPermissions", "", "getTargetPermissions", "()[Ljava/lang/String;", "setTargetPermissions", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getPlayModes", "Companion", "StartType", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FastStartLiveConfig implements Serializable {
    public static final Companion Companion = null;
    public static final String PLAY_MODE = "play_mode";
    private static final long serialVersionUID = 0;
    private boolean isAutoEnterBroadcast;
    private boolean isAutoFinishOnLiveStarted;
    private boolean isNeeVcdAuthorize;
    private boolean isNeedVerify;
    private boolean isPreInitCreateInfo;
    private boolean isPreInitUserPermission;
    private boolean isTransparentPageForSchema;
    private LiveMode liveMode;
    private ArrayList<Integer> playMode;
    private String sourcePrams;
    private int startType;
    private String[] targetPermissions;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/config/FastStartLiveConfig$Companion;", "", "()V", "PLAY_MODE", "", "serialVersionUID", "", "getPlayModes", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "sourceParams", "Lorg/json/JSONObject;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final ArrayList<Integer> getPlayModes(JSONObject r100) {
            if (r100 != null) goto L16;
            return null;
        L16:
            JSONArray r101 = JSONObjectProtectorUtils.getJSONArray(r100, FastStartLiveConfig.PLAY_MODE);     // Catch: Exception -> L15
            if (r101 == null) goto L21;
            ArrayList<Integer> r102 = new ArrayList();     // Catch: Exception -> L15
            int r103 = r101.length();     // Catch: Exception -> L14
            int r104 = 0;
        L9:
            if (r104 >= r103) goto L13;
            r102.add(Integer.valueOf(JSONArrayProtectorUtils.getInt(r101, r104)));     // Catch: Exception -> L14
            r104 = r104 + 1;
        L13:
            return r102;
        L21:
            return null;
        L22:
            return null;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/config/FastStartLiveConfig$StartType;", "", "Companion", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface StartType {
        public static final Companion Companion = null;
        public static final int FRIENDS_KTV = 2;
        public static final int WATCH_TOGETHER = 1;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/config/FastStartLiveConfig$StartType$Companion;", "", "()V", "FRIENDS_KTV", "", "WATCH_TOGETHER", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;
            public static final int FRIENDS_KTV = 2;
            public static final int WATCH_TOGETHER = 1;

            private Companion() {
            }

            static {
                $$INSTANCE = new Companion();
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void getStartType$annotations() {
    }

    public final ArrayList<Integer> getPlayModes() {
        ArrayList<Integer> r100 = null;
        if (this.sourcePrams != null) goto L5;
        return null;
    L5:
        ArrayList<Integer> r101 = this.playMode;
        if (r101 == null) goto L20;
        return r101;
    L20:
        JSONArray r102 = JSONObjectProtectorUtils.getJSONArray(new JSONObject(this.sourcePrams), PLAY_MODE);     // Catch: Exception -> L19
        if (r102 == null) goto L16;
        ArrayList<Integer> r103 = new ArrayList();     // Catch: Exception -> L19
        int r104 = r102.length();     // Catch: Exception -> L18
        int r105 = 0;
    L12:
        if (r105 >= r104) goto L15;
        r103.add(Integer.valueOf(JSONArrayProtectorUtils.getInt(r102, r105)));     // Catch: Exception -> L18
        r105 = r105 + 1;
    L15:
        r100 = r103;
    L16:
        this.playMode = r100;
        return r100;
    }

    public FastStartLiveConfig() {
        this.isAutoEnterBroadcast = true;
        this.isNeedVerify = true;
        this.isPreInitUserPermission = true;
        this.isPreInitCreateInfo = true;
        this.isNeeVcdAuthorize = true;
        this.startType = 1;
    }

    public final LiveMode getLiveMode() {
        return this.liveMode;
    }

    public final ArrayList<Integer> getPlayMode() {
        return this.playMode;
    }

    public final String getSourcePrams() {
        return this.sourcePrams;
    }

    public final int getStartType() {
        return this.startType;
    }

    public final String[] getTargetPermissions() {
        return this.targetPermissions;
    }

    public final boolean isAutoEnterBroadcast() {
        return this.isAutoEnterBroadcast;
    }

    public final boolean isAutoFinishOnLiveStarted() {
        return this.isAutoFinishOnLiveStarted;
    }

    public final boolean isNeeVcdAuthorize() {
        return this.isNeeVcdAuthorize;
    }

    public final boolean isNeedVerify() {
        return this.isNeedVerify;
    }

    public final boolean isPreInitCreateInfo() {
        return this.isPreInitCreateInfo;
    }

    public final boolean isPreInitUserPermission() {
        return this.isPreInitUserPermission;
    }

    public final boolean isTransparentPageForSchema() {
        return this.isTransparentPageForSchema;
    }

    public final void setAutoEnterBroadcast(boolean r100) {
        this.isAutoEnterBroadcast = r100;
    }

    public final void setAutoFinishOnLiveStarted(boolean r100) {
        this.isAutoFinishOnLiveStarted = r100;
    }

    public final void setLiveMode(LiveMode r100) {
        this.liveMode = r100;
    }

    public final void setNeeVcdAuthorize(boolean r100) {
        this.isNeeVcdAuthorize = r100;
    }

    public final void setNeedVerify(boolean r100) {
        this.isNeedVerify = r100;
    }

    public final void setPlayMode(ArrayList<Integer> r100) {
        this.playMode = r100;
    }

    public final void setPreInitCreateInfo(boolean r100) {
        this.isPreInitCreateInfo = r100;
    }

    public final void setPreInitUserPermission(boolean r100) {
        this.isPreInitUserPermission = r100;
    }

    public final void setSourcePrams(String r100) {
        this.sourcePrams = r100;
    }

    public final void setStartType(int r100) {
        this.startType = r100;
    }

    public final void setTargetPermissions(String[] r100) {
        this.targetPermissions = r100;
    }

    public final void setTransparentPageForSchema(boolean r100) {
        this.isTransparentPageForSchema = r100;
    }
}
