package com.obric.download.base;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.capabilitykit.common.UiType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\u0016\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b1\u0018\u0000 U2\u00020\u0001:\u0001VBõ\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\r\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\t\u0012\b\b\u0002\u0010\u001c\u001a\u00020\r\u0012\b\b\u0002\u0010\u001d\u001a\u00020\t\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\r¢\u0006\u0004\b \u0010!B\u0011\b\u0016\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b \u0010$J\u001f\u0010'\u001a\u00020&2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020\tH\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\tH\u0016¢\u0006\u0004\b)\u0010*R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010+\u001a\u0004\b.\u0010-R\u001f\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010/\u001a\u0004\b0\u00101R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010+\u001a\u0004\b2\u0010-R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010+\u001a\u0004\b3\u0010-R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u00104\u001a\u0004\b5\u0010*R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010+\u001a\u0004\b6\u0010-R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010+\u001a\u0004\b7\u0010-R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u00108\u001a\u0004\b9\u0010:R\u0017\u0010\u000f\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000f\u00108\u001a\u0004\b;\u0010:R%\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010<\u001a\u0004\b=\u0010>R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010+\u001a\u0004\b?\u0010-R\u0017\u0010\u0013\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0013\u00108\u001a\u0004\b@\u0010:R\u0017\u0010\u0014\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0014\u00104\u001a\u0004\bA\u0010*R\u0017\u0010\u0015\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0015\u00108\u001a\u0004\bB\u0010:R\u0017\u0010\u0016\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0016\u00104\u001a\u0004\bC\u0010*R\u0017\u0010\u0017\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\bD\u0010-R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010E\u001a\u0004\bF\u0010GR\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010+\u001a\u0004\bH\u0010-\"\u0004\bI\u0010JR\"\u0010\u001b\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u00104\u001a\u0004\bK\u0010*\"\u0004\bL\u0010MR\"\u0010\u001c\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u00108\u001a\u0004\b\u001c\u0010:\"\u0004\bN\u0010OR\"\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u00104\u001a\u0004\bP\u0010*\"\u0004\bQ\u0010MR$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010+\u001a\u0004\bR\u0010-\"\u0004\bS\u0010JR\"\u0010\u001f\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u00108\u001a\u0004\b\u001f\u0010:\"\u0004\bT\u0010O¨\u0006W"}, d2 = {"Lcom/obric/download/base/DownloadTask;", "Landroid/os/Parcelable;", "", "url", "name", "", "backupUrls", "title", "savePath", "", "segmentNum", "apkPackageName", "iconUrl", "", "onlyWifi", "showNotification", "", "extraHeaders", ServerElements.MD5, "autoResumed", "retryCount", "needRetryDelay", "versionCode", "versionName", "", "retryDelayTimeArray", "hostPkgName", "id", "isPriorityDownload", "minProgressInterval", "extraInfo", "isForceDownload", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZZLjava/util/Map;Ljava/lang/String;ZIZILjava/lang/String;[JLjava/lang/String;IZILjava/lang/String;Z)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "getName", "Ljava/util/List;", "getBackupUrls", "()Ljava/util/List;", "getTitle", "getSavePath", "I", "getSegmentNum", "getApkPackageName", "getIconUrl", "Z", "getOnlyWifi", "()Z", "getShowNotification", "Ljava/util/Map;", "getExtraHeaders", "()Ljava/util/Map;", "getMd5", "getAutoResumed", "getRetryCount", "getNeedRetryDelay", "getVersionCode", "getVersionName", "[J", "getRetryDelayTimeArray", "()[J", "getHostPkgName", "setHostPkgName", "(Ljava/lang/String;)V", "getId", "setId", "(I)V", "setPriorityDownload", "(Z)V", "getMinProgressInterval", "setMinProgressInterval", "getExtraInfo", "setExtraInfo", "setForceDownload", "CREATOR", "a", "base_release"}, k = 1, mv = {1, 4, 3})
public final class DownloadTask implements Parcelable {

    @NotNull
    public static final a CREATOR = null;

    @Nullable
    private final String apkPackageName;
    private final boolean autoResumed;

    @Nullable
    private final List<String> backupUrls;

    @Nullable
    private final Map<String, String> extraHeaders;

    @Nullable
    private String extraInfo;

    @NotNull
    private String hostPkgName;

    @Nullable
    private final String iconUrl;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f11861id;
    private boolean isForceDownload;
    private boolean isPriorityDownload;

    @Nullable
    private final String md5;
    private int minProgressInterval;

    @NotNull
    private final String name;
    private final boolean needRetryDelay;
    private final boolean onlyWifi;
    private final int retryCount;

    @Nullable
    private final long[] retryDelayTimeArray;

    @NotNull
    private final String savePath;
    private final int segmentNum;
    private final boolean showNotification;

    @Nullable
    private final String title;

    @NotNull
    private final String url;
    private final int versionCode;

    @NotNull
    private final String versionName;

    public static final class a implements Parcelable.Creator {
        public a() {
        }

        public DownloadTask a(Parcel r10) {
            q.g(r10, "parcel");
            return new DownloadTask(r10);
        }

        public DownloadTask[] b(int r10) {
            return new DownloadTask[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
            return b(r10);
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        CREATOR = new a(null);
    }

    public DownloadTask(@NotNull String r10, @NotNull String r11, @Nullable List<String> r12, @Nullable String r13, @NotNull String r14, int r15, @Nullable String r16, @Nullable String r17, boolean r18, boolean r19, @Nullable Map<String, String> r110, @Nullable String r111, boolean r20, int r21, boolean r22, int r23, @NotNull String r24, @Nullable long[] r25, @NotNull String r26, int r27, boolean r28, int r29, @Nullable String r30, boolean r31) {
        q.g(r10, "url");
        q.g(r11, "name");
        q.g(r14, "savePath");
        q.g(r24, "versionName");
        q.g(r26, "hostPkgName");
        this.url = r10;
        this.name = r11;
        this.backupUrls = r12;
        this.title = r13;
        this.savePath = r14;
        this.segmentNum = r15;
        this.apkPackageName = r16;
        this.iconUrl = r17;
        this.onlyWifi = r18;
        this.showNotification = r19;
        this.extraHeaders = r110;
        this.md5 = r111;
        this.autoResumed = r20;
        this.retryCount = r21;
        this.needRetryDelay = r22;
        this.versionCode = r23;
        this.versionName = r24;
        this.retryDelayTimeArray = r25;
        this.hostPkgName = r26;
        this.f11861id = r27;
        this.isPriorityDownload = r28;
        this.minProgressInterval = r29;
        this.extraInfo = r30;
        this.isForceDownload = r31;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getApkPackageName() {
        return this.apkPackageName;
    }

    public final boolean getAutoResumed() {
        return this.autoResumed;
    }

    @Nullable
    public final List<String> getBackupUrls() {
        return this.backupUrls;
    }

    @Nullable
    public final Map<String, String> getExtraHeaders() {
        return this.extraHeaders;
    }

    @Nullable
    public final String getExtraInfo() {
        return this.extraInfo;
    }

    @NotNull
    public final String getHostPkgName() {
        return this.hostPkgName;
    }

    @Nullable
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final int getId() {
        return this.f11861id;
    }

    @Nullable
    public final String getMd5() {
        return this.md5;
    }

    public final int getMinProgressInterval() {
        return this.minProgressInterval;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final boolean getNeedRetryDelay() {
        return this.needRetryDelay;
    }

    public final boolean getOnlyWifi() {
        return this.onlyWifi;
    }

    public final int getRetryCount() {
        return this.retryCount;
    }

    @Nullable
    public final long[] getRetryDelayTimeArray() {
        return this.retryDelayTimeArray;
    }

    @NotNull
    public final String getSavePath() {
        return this.savePath;
    }

    public final int getSegmentNum() {
        return this.segmentNum;
    }

    public final boolean getShowNotification() {
        return this.showNotification;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    @NotNull
    public final String getVersionName() {
        return this.versionName;
    }

    public final boolean isForceDownload() {
        return this.isForceDownload;
    }

    public final boolean isPriorityDownload() {
        return this.isPriorityDownload;
    }

    public final void setExtraInfo(@Nullable String r10) {
        this.extraInfo = r10;
    }

    public final void setForceDownload(boolean r10) {
        this.isForceDownload = r10;
    }

    public final void setHostPkgName(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.hostPkgName = r10;
    }

    public final void setId(int r10) {
        this.f11861id = r10;
    }

    public final void setMinProgressInterval(int r10) {
        this.minProgressInterval = r10;
    }

    public final void setPriorityDownload(boolean r10) {
        this.isPriorityDownload = r10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        r10.writeString(this.url);
        r10.writeString(this.name);
        r10.writeStringList(this.backupUrls);
        r10.writeString(this.title);
        r10.writeString(this.savePath);
        r10.writeInt(this.segmentNum);
        r10.writeString(this.apkPackageName);
        r10.writeString(this.iconUrl);
        r10.writeByte(this.onlyWifi ? 1 : 0);
        r10.writeByte(this.showNotification ? 1 : 0);
        r10.writeMap(this.extraHeaders);
        r10.writeString(this.md5);
        r10.writeByte(this.autoResumed ? 1 : 0);
        r10.writeInt(this.retryCount);
        r10.writeByte(this.needRetryDelay ? 1 : 0);
        r10.writeInt(this.versionCode);
        r10.writeString(this.versionName);
        r10.writeLongArray(this.retryDelayTimeArray);
        r10.writeString(this.hostPkgName);
        r10.writeInt(this.f11861id);
        r10.writeBoolean(this.isPriorityDownload);
        r10.writeInt(this.minProgressInterval);
        r10.writeString(this.extraInfo);
        r10.writeBoolean(this.isForceDownload);
    }

    public /* synthetic */ DownloadTask(String r29, String r30, List r31, String r32, String r33, int r34, String r35, String r36, boolean r37, boolean r38, Map r39, String r40, boolean r41, int r42, boolean r43, int r44, String r45, long[] r46, String r47, int r48, boolean r49, int r50, String r51, boolean r52, int r53, DefaultConstructorMarker r54) {
        if ((r53 & 8192) == 0) goto L5;
        int r17 = 0;
    L7:
        if ((262144 & r53) == 0) goto L9;
        String r22 = "";
    L11:
        if ((524288 & r53) == 0) goto L13;
        int r23 = -1;
    L15:
        if ((1048576 & r53) == 0) goto L17;
        boolean r24 = false;
    L19:
        if ((2097152 & r53) == 0) goto L21;
        int r25 = 500;
    L23:
        if ((r53 & UiType.FLAG_APPLET_CARD) == 0) goto L25;
        boolean r27 = false;
    L26:
        this(r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r17, r43, r44, r45, r46, r22, r23, r24, r25, r51, r27);
        return;
    L25:
        r27 = r52;
        goto L26
    L21:
        r25 = r50;
        goto L23
    L17:
        r24 = r49;
        goto L19
    L13:
        r23 = r48;
        goto L15
    L9:
        r22 = r47;
        goto L11
    L5:
        r17 = r42;
        goto L7
    }

    public DownloadTask(@NotNull Parcel r31) {
        q.g(r31, "parcel");
        String r10 = r31.readString();
        q.d(r10);
        q.f(r10, "parcel.readString()!!");
        String r11 = r31.readString();
        q.d(r11);
        q.f(r11, "parcel.readString()!!");
        ArrayList<String> r12 = r31.createStringArrayList();
        String r13 = r31.readString();
        String r14 = r31.readString();
        q.d(r14);
        q.f(r14, "parcel.readString()!!");
        int r15 = r31.readInt();
        String r16 = r31.readString();
        String r17 = r31.readString();
        byte r18 = (byte) 0;
        if (r31.readByte() == r18) goto L5;
        boolean r19 = true;
    L7:
        if (r31.readByte() == r18) goto L9;
        boolean r110 = true;
    L10:
        HashMap r20 = r31.readHashMap(HashMap.class.getClassLoader());
        if (r20 != null) goto L13;
        r20 = null;
    L13:
        HashMap r111 = r20;
        String r112 = r31.readString();
        if (r31.readByte() == r18) goto L16;
        boolean r27 = true;
    L17:
        int r28 = r31.readInt();
        if (r31.readByte() == r18) goto L20;
        boolean r29 = true;
    L21:
        int r113 = r31.readInt();
        String r21 = r31.readString();
        q.d(r21);
        q.f(r21, "parcel.readString()!!");
        long[] r22 = r31.createLongArray();
        String r23 = r31.readString();
        q.d(r23);
        q.f(r23, "parcel.readString()!!");
        this(r10, r11, r12, r13, r14, r15, r16, r17, r19, r110, r111, r112, r27, r28, r29, r113, r21, r22, r23, r31.readInt(), r31.readBoolean(), r31.readInt(), r31.readString(), r31.readBoolean());
        return;
    L20:
        r29 = false;
        goto L21
    L16:
        r27 = false;
        goto L17
    L9:
        r110 = false;
        goto L10
    L5:
        r19 = false;
        goto L7
    }
}
