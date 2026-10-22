package com.bytedance.android.livehostapi.business.depend.gamecp;

import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0006\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010`\u001a\u00020\u00162\u0006\u0010a\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010b\u001a\u00020F2\b\u0010c\u001a\u0004\u0018\u00010dH\u0096\u0002J\b\u0010e\u001a\u0004\u0018\u00010fJ\b\u0010g\u001a\u0004\u0018\u00010\u0006J\u0006\u0010h\u001a\u00020\u0003J\b\u0010i\u001a\u00020\u0016H\u0016J\b\u0010j\u001a\u00020FH\u0002J\u0010\u0010k\u001a\u00020l2\b\u0010m\u001a\u0004\u0018\u00010\u0006R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\nR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\b\"\u0004\b \u0010\nR\u001c\u0010!\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\b\"\u0004\b#\u0010\nR\u001a\u0010$\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010\u0004R\u001a\u0010'\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R\u001c\u00103\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\b\"\u0004\b5\u0010\nR\u001a\u00106\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\r\"\u0004\b8\u0010\u0004R\u001a\u00109\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0018\"\u0004\b;\u0010\u001aR\u001c\u0010<\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\b\"\u0004\b>\u0010\nR\u001a\u0010?\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0018\"\u0004\bA\u0010\u001aR\u001a\u0010B\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0018\"\u0004\bD\u0010\u001aR\u001a\u0010E\u001a\u00020FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020LX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001a\u0010Q\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0018\"\u0004\bS\u0010\u001aR\u001c\u0010T\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\b\"\u0004\bV\u0010\nR\u001a\u0010W\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u0018\"\u0004\bY\u0010\u001aR\u001c\u0010Z\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\b\"\u0004\b\\\u0010\nR\u001a\u0010]\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u0018\"\u0004\b_\u0010\u001a¨\u0006n"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/MediaModel;", "", "id", "", "(J)V", "compressPath", "", "getCompressPath", "()Ljava/lang/String;", "setCompressPath", "(Ljava/lang/String;)V", "date", "getDate", "()J", "setDate", "dateToken", "getDateToken", "setDateToken", "duration", "getDuration", "setDuration", "endTime", "", "getEndTime", "()I", "setEndTime", "(I)V", "extraInfo", "getExtraInfo", "setExtraInfo", "fileLocalUriPath", "getFileLocalUriPath", "setFileLocalUriPath", "fileName", "getFileName", "setFileName", "fileSize", "getFileSize", "setFileSize", "height", "getHeight", "setHeight", "latitude", "", "getLatitude", "()D", "setLatitude", "(D)V", "longitude", "getLongitude", "setLongitude", DBDefinition.MIME_TYPE, "getMimeType", "setMimeType", PriorityModule.OPERATOR_MODIFY, "getModify", "setModify", "orientation", "getOrientation", "setOrientation", "relativePath", "getRelativePath", "setRelativePath", "selectIndex", "getSelectIndex", "setSelectIndex", "selectPosition", "getSelectPosition", "setSelectPosition", "selectState", "", "getSelectState", "()Z", "setSelectState", "(Z)V", "speed", "", "getSpeed", "()F", "setSpeed", "(F)V", DyPayConstant.KEY_START_TIME, "getStartTime", "setStartTime", DocCallbackImpl.KEY_THUMBNAIL, "getThumbnail", "setThumbnail", "type", "getType", "setType", "uri", "getUri", "setUri", "width", "getWidth", "setWidth", "compareTo", "another", "equals", "other", "", "getDisplayResolution", "", "getExtra", "getId", "hashCode", "isReverseWidthHeight", "setExtra", "", "extra", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class MediaModel implements Comparable<MediaModel> {
    private String compressPath;
    private long date;
    private long dateToken;
    private long duration;
    private int endTime;
    private String extraInfo;
    private String fileLocalUriPath;
    private String fileName;
    private long fileSize;
    private int height;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f102924id;
    private double latitude;
    private double longitude;
    private String mimeType;
    private long modify;
    private int orientation;
    private String relativePath;
    private int selectIndex;
    private int selectPosition;
    private boolean selectState;
    private float speed;
    private int startTime;
    private String thumbnail;
    private int type;
    private String uri;
    private int width;

    private final boolean isReverseWidthHeight() {
        int r100 = this.orientation;
        if (r100 != 6) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 8) goto L8;
        return false;
    }

    public int hashCode() {
        long r100 = this.f102924id;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public final int[] getDisplayResolution() {
        if (isReverseWidthHeight() == false) goto L6;
        return new int[]{this.height, this.width};
    L6:
        return new int[]{this.width, this.height};
    }

    public final String getCompressPath() {
        return this.compressPath;
    }

    public final long getDate() {
        return this.date;
    }

    public final long getDateToken() {
        return this.dateToken;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final int getEndTime() {
        return this.endTime;
    }

    public final String getExtra() {
        return this.extraInfo;
    }

    public final String getExtraInfo() {
        return this.extraInfo;
    }

    public final String getFileLocalUriPath() {
        return this.fileLocalUriPath;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final int getHeight() {
        return this.height;
    }

    public final long getId() {
        return this.f102924id;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final long getModify() {
        return this.modify;
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final String getRelativePath() {
        return this.relativePath;
    }

    public final int getSelectIndex() {
        return this.selectIndex;
    }

    public final int getSelectPosition() {
        return this.selectPosition;
    }

    public final boolean getSelectState() {
        return this.selectState;
    }

    public final float getSpeed() {
        return this.speed;
    }

    public final int getStartTime() {
        return this.startTime;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUri() {
        return this.uri;
    }

    public final int getWidth() {
        return this.width;
    }

    public MediaModel(long r100) {
        this.f102924id = r100;
        this.width = -1;
        this.height = -1;
        this.speed = 1.0f;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MediaModel r100) {
        Intrinsics.checkNotNullParameter(r100, "another");
        long r101 = this.date;
        long r102 = r100.date;
        if (r101 <= r102) goto L7;
        return -1;
    L7:
        if (r101 >= r102) goto L10;
        return 1;
    L10:
        return 0;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof MediaModel) == true) goto L9;
    L7:
        return false;
    L9:
        if (this.f102924id != ((MediaModel) r100).f102924id) goto L7;
        return true;
    }

    public final void setCompressPath(String r100) {
        this.compressPath = r100;
    }

    public final void setDate(long r100) {
        this.date = r100;
    }

    public final void setDateToken(long r100) {
        this.dateToken = r100;
    }

    public final void setDuration(long r100) {
        this.duration = r100;
    }

    public final void setEndTime(int r100) {
        this.endTime = r100;
    }

    public final void setExtra(String r100) {
        this.extraInfo = r100;
    }

    public final void setExtraInfo(String r100) {
        this.extraInfo = r100;
    }

    public final void setFileLocalUriPath(String r100) {
        this.fileLocalUriPath = r100;
    }

    public final void setFileName(String r100) {
        this.fileName = r100;
    }

    public final void setFileSize(long r100) {
        this.fileSize = r100;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setLatitude(double r100) {
        this.latitude = r100;
    }

    public final void setLongitude(double r100) {
        this.longitude = r100;
    }

    public final void setMimeType(String r100) {
        this.mimeType = r100;
    }

    public final void setModify(long r100) {
        this.modify = r100;
    }

    public final void setOrientation(int r100) {
        this.orientation = r100;
    }

    public final void setRelativePath(String r100) {
        this.relativePath = r100;
    }

    public final void setSelectIndex(int r100) {
        this.selectIndex = r100;
    }

    public final void setSelectPosition(int r100) {
        this.selectPosition = r100;
    }

    public final void setSelectState(boolean r100) {
        this.selectState = r100;
    }

    public final void setSpeed(float r100) {
        this.speed = r100;
    }

    public final void setStartTime(int r100) {
        this.startTime = r100;
    }

    public final void setThumbnail(String r100) {
        this.thumbnail = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }

    public final void setUri(String r100) {
        this.uri = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(MediaModel r100) {
        return compareTo2(r100);
    }
}
