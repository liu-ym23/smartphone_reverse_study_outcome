package com.bytedance.android.livesdk.model;

import com.google.gson.annotations.SerializedName;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b$\b\u0007\u0018\u0000 O2\u00020\u0001:\u0001PB\u0007¢\u0006\u0004\bM\u0010NJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\"\u0010!\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\"\u0010$\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0019\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR\"\u0010'\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\t\u001a\u0004\b(\u0010\u000b\"\u0004\b)\u0010\rR\"\u0010*\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\t\u001a\u0004\b+\u0010\u000b\"\u0004\b,\u0010\rR\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b4\u0010\u0011\"\u0004\b5\u0010\u0013R\"\u00106\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010\t\u001a\u0004\b7\u0010\u000b\"\u0004\b8\u0010\rR\"\u00109\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010\t\u001a\u0004\b:\u0010\u000b\"\u0004\b;\u0010\rR\"\u0010<\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010\t\u001a\u0004\b=\u0010\u000b\"\u0004\b>\u0010\rR\"\u0010?\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010\t\u001a\u0004\b@\u0010\u000b\"\u0004\bA\u0010\rR\"\u0010B\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bB\u0010D\"\u0004\bE\u0010FR\"\u0010G\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bG\u0010\t\u001a\u0004\bH\u0010\u000b\"\u0004\bI\u0010\rR\u0011\u0010J\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bJ\u0010DR\u0013\u0010L\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\bK\u0010\u0011¨\u0006Q"}, d2 = {"Lcom/bytedance/android/livesdk/model/RevSeiRegion;", "", "", "uidStr", "", "isExceptionData", "isMuteAudio", "", "type", "I", "getType", "()I", "setType", "(I)V", "account", "Ljava/lang/String;", "getAccount", "()Ljava/lang/String;", "setAccount", "(Ljava/lang/String;)V", "alpha", "getAlpha", "setAlpha", "", "width", "D", "getWidth", "()D", "setWidth", "(D)V", "height", "getHeight", "setHeight", "x", "getX", "setX", "y", "getY", "setY", "zOrder", "getZOrder", "setZOrder", "status", "getStatus", "setStatus", "", "uid", "J", "getUid", "()J", "setUid", "(J)V", "getUidStr", "setUidStr", "talk", "getTalk", "setTalk", "muteAudio", "getMuteAudio", "setMuteAudio", "talkVolume", "getTalkVolume", "setTalkVolume", "position", "getPosition", "setPosition", "isLocal", "Z", "()Z", "setLocal", "(Z)V", "windowType", "getWindowType", "setWindowType", "isTalking", "getInteractId", "interactId", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevSeiRegion {
    public static final a Companion = null;
    public static final int STATE_CONNECTION_LOST = 1;
    public static final int STATE_NORMAL = 0;
    public static final int TYPE_AUDIO = 2;
    public static final int TYPE_PLACEHOLDER = 0;
    public static final int TYPE_VIDEO = 1;

    @SerializedName("account")
    private String account;

    @SerializedName("alpha")
    private int alpha;

    @SerializedName("h")
    private double height;

    @SerializedName("loading")
    private boolean isLocal;

    @SerializedName("mute_audio")
    private int muteAudio;

    @SerializedName("p")
    private int position;

    @SerializedName(CloudControlInf.STAT)
    private int status;

    @SerializedName("talk")
    private int talk;

    @SerializedName("talk_volume")
    private int talkVolume;

    @SerializedName("type")
    private int type;

    @SerializedName("uid")
    private long uid;

    @SerializedName("uid_str")
    private String uidStr;

    @SerializedName("w")
    private double width;

    @SerializedName("w_type")
    private int windowType;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    private double f153917x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    private double f153918y;

    @SerializedName("zorder")
    private int zOrder;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public RevSeiRegion() {
    }

    public final String getInteractId() {
        String r100 = this.uidStr;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L15;
        if (isExceptionData(this.uidStr) == true) goto L15;
        return this.uidStr;
    L15:
        return String.valueOf(this.uid);
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final boolean isMuteAudio() {
        if (this.muteAudio == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isTalking() {
        if (this.talk <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getAccount() {
        return this.account;
    }

    public final int getAlpha() {
        return this.alpha;
    }

    public final double getHeight() {
        return this.height;
    }

    public final int getMuteAudio() {
        return this.muteAudio;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getTalk() {
        return this.talk;
    }

    public final int getTalkVolume() {
        return this.talkVolume;
    }

    public final int getType() {
        return this.type;
    }

    public final long getUid() {
        return this.uid;
    }

    public final String getUidStr() {
        return this.uidStr;
    }

    public final double getWidth() {
        return this.width;
    }

    public final int getWindowType() {
        return this.windowType;
    }

    public final double getX() {
        return this.f153917x;
    }

    public final double getY() {
        return this.f153918y;
    }

    public final int getZOrder() {
        return this.zOrder;
    }

    public final boolean isLocal() {
        return this.isLocal;
    }

    private final boolean isExceptionData(String r100) {
        if (Intrinsics.areEqual("null", r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual("nil", r100) == true) goto L8;
        return false;
    }

    public final void setAccount(String r100) {
        this.account = r100;
    }

    public final void setAlpha(int r100) {
        this.alpha = r100;
    }

    public final void setHeight(double r100) {
        this.height = r100;
    }

    public final void setLocal(boolean r100) {
        this.isLocal = r100;
    }

    public final void setMuteAudio(int r100) {
        this.muteAudio = r100;
    }

    public final void setPosition(int r100) {
        this.position = r100;
    }

    public final void setStatus(int r100) {
        this.status = r100;
    }

    public final void setTalk(int r100) {
        this.talk = r100;
    }

    public final void setTalkVolume(int r100) {
        this.talkVolume = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }

    public final void setUid(long r100) {
        this.uid = r100;
    }

    public final void setUidStr(String r100) {
        this.uidStr = r100;
    }

    public final void setWidth(double r100) {
        this.width = r100;
    }

    public final void setWindowType(int r100) {
        this.windowType = r100;
    }

    public final void setX(double r100) {
        this.f153917x = r100;
    }

    public final void setY(double r100) {
        this.f153918y = r100;
    }

    public final void setZOrder(int r100) {
        this.zOrder = r100;
    }
}
