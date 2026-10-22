package com.bytedance.android.live.base.model.user;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.data.User.NobleLevelInfo")
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b-\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bI\u0010JJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0007H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001eH\u0016J\u0018\u0010!\u001a\u00020\u00052\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001eH\u0016R$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010#\u001a\u0004\b/\u0010%\"\u0004\b0\u0010'R$\u00101\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010#\u001a\u0004\b2\u0010%\"\u0004\b3\u0010'R$\u00104\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010#\u001a\u0004\b5\u0010%\"\u0004\b6\u0010'R$\u00107\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010=\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010)\u001a\u0004\b>\u0010+\"\u0004\b?\u0010-R$\u0010@\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010#\u001a\u0004\bA\u0010%\"\u0004\bB\u0010'R*\u0010C\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006K"}, d2 = {"Lcom/bytedance/android/live/base/model/user/NobleLevelInfo;", "", "Lcom/bytedance/android/live/base/model/ImageModel;", "getNobleBackground", "nobleBackground", "", "setNobleBackground", "", "getNobleLevel", "nobleLevel", "setNobleLevel", "getNobleIcon", "nobleIcon", "setNobleIcon", "", "getNobleName", "nobleName", "setNobleName", "getNobleBigIcon", "nobleBigIcon", "setNobleBigIcon", "getNobleIconWithBack", "nobleIconWithBack", "setNobleIconWithBack", "getExpireTime", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "setExpireTime", "getNobleBoarder", "nobleBoarder", "setNobleBoarder", "", "getNobleBackgroundColor", "nobleBackgroundColor", "setNobleBackgroundColor", "_nobleBackground", "Lcom/bytedance/android/live/base/model/ImageModel;", "get_nobleBackground", "()Lcom/bytedance/android/live/base/model/ImageModel;", "set_nobleBackground", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "_nobleLevel", "J", "get_nobleLevel", "()J", "set_nobleLevel", "(J)V", "_nobleIcon", "get_nobleIcon", "set_nobleIcon", "_nobleBigIcon", "get_nobleBigIcon", "set_nobleBigIcon", "_nobleIconWithBack", "get_nobleIconWithBack", "set_nobleIconWithBack", "_nobleName", "Ljava/lang/String;", "get_nobleName", "()Ljava/lang/String;", "set_nobleName", "(Ljava/lang/String;)V", "_expireTime", "get_expireTime", "set_expireTime", "_nobleBoarder", "get_nobleBoarder", "set_nobleBoarder", "_nobleBackgroundColor", "Ljava/util/List;", "get_nobleBackgroundColor", "()Ljava/util/List;", "set_nobleBackgroundColor", "(Ljava/util/List;)V", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NobleLevelInfo implements vh7.h {

    @SerializedName("expire_time")
    protected long _expireTime;

    @SerializedName("noble_background")
    protected ImageModel _nobleBackground;

    @SerializedName("noble_background_color")
    protected List<String> _nobleBackgroundColor;

    @SerializedName("noble_big_icon")
    protected ImageModel _nobleBigIcon;

    @SerializedName("noble_boarder")
    protected ImageModel _nobleBoarder;

    @SerializedName("noble_icon")
    protected ImageModel _nobleIcon;

    @SerializedName("noble_icon_with_back")
    protected ImageModel _nobleIconWithBack;

    @SerializedName("noble_level")
    protected long _nobleLevel;

    @SerializedName("noble_name")
    protected String _nobleName;

    public NobleLevelInfo() {
    }

    /* JADX INFO: renamed from: getNobleBackground, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ py.k m8162getNobleBackground() {
        return getNobleBackground();
    }

    /* JADX INFO: renamed from: getNobleBigIcon, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ py.k m8163getNobleBigIcon() {
        return getNobleBigIcon();
    }

    /* JADX INFO: renamed from: getNobleBoarder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ py.k m8164getNobleBoarder() {
        return getNobleBoarder();
    }

    /* JADX INFO: renamed from: getNobleIcon, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ py.k m8165getNobleIcon() {
        return getNobleIcon();
    }

    /* JADX INFO: renamed from: getNobleIconWithBack, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ py.k m8166getNobleIconWithBack() {
        return getNobleIconWithBack();
    }

    public long getExpireTime() {
        return this._expireTime;
    }

    public List<String> getNobleBackgroundColor() {
        return this._nobleBackgroundColor;
    }

    public long getNobleLevel() {
        return this._nobleLevel;
    }

    public String getNobleName() {
        return this._nobleName;
    }

    public final long get_expireTime() {
        return this._expireTime;
    }

    public final ImageModel get_nobleBackground() {
        return this._nobleBackground;
    }

    public final List<String> get_nobleBackgroundColor() {
        return this._nobleBackgroundColor;
    }

    public final ImageModel get_nobleBigIcon() {
        return this._nobleBigIcon;
    }

    public final ImageModel get_nobleBoarder() {
        return this._nobleBoarder;
    }

    public final ImageModel get_nobleIcon() {
        return this._nobleIcon;
    }

    public final ImageModel get_nobleIconWithBack() {
        return this._nobleIconWithBack;
    }

    public final long get_nobleLevel() {
        return this._nobleLevel;
    }

    public final String get_nobleName() {
        return this._nobleName;
    }

    public ImageModel getNobleBackground() {
        return this._nobleBackground;
    }

    public ImageModel getNobleBigIcon() {
        return this._nobleBigIcon;
    }

    public ImageModel getNobleBoarder() {
        return this._nobleBoarder;
    }

    public ImageModel getNobleIcon() {
        return this._nobleIcon;
    }

    public ImageModel getNobleIconWithBack() {
        return this._nobleIconWithBack;
    }

    public NobleLevelInfo(am3.g r100) {
        this._nobleBackgroundColor = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        switch(r102) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        this._nobleBackgroundColor.add(am3.h.c(r100));
        goto L3
    L8:
        this._nobleBoarder = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L9:
        this._nobleIconWithBack = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L10:
        this._nobleBigIcon = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L11:
        this._expireTime = r100.j();
        goto L3
    L12:
        this._nobleName = am3.h.c(r100);
        goto L3
    L13:
        this._nobleIcon = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L14:
        this._nobleLevel = r100.j();
        goto L3
    L15:
        this._nobleBackground = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L16:
        r100.d(r101);
    }

    public void setExpireTime(long r100) {
        this._expireTime = r100;
    }

    public final void setNobleBackground(ImageModel r100) {
        this._nobleBackground = r100;
    }

    public void setNobleBackgroundColor(List<String> r100) {
        this._nobleBackgroundColor = r100;
    }

    public final void setNobleBigIcon(ImageModel r100) {
        this._nobleBigIcon = r100;
    }

    public final void setNobleBoarder(ImageModel r100) {
        this._nobleBoarder = r100;
    }

    public final void setNobleIcon(ImageModel r100) {
        this._nobleIcon = r100;
    }

    public final void setNobleIconWithBack(ImageModel r100) {
        this._nobleIconWithBack = r100;
    }

    public void setNobleLevel(long r100) {
        this._nobleLevel = r100;
    }

    public void setNobleName(String r100) {
        this._nobleName = r100;
    }

    public final void set_expireTime(long r100) {
        this._expireTime = r100;
    }

    public final void set_nobleBackground(ImageModel r100) {
        this._nobleBackground = r100;
    }

    public final void set_nobleBackgroundColor(List<String> r100) {
        this._nobleBackgroundColor = r100;
    }

    public final void set_nobleBigIcon(ImageModel r100) {
        this._nobleBigIcon = r100;
    }

    public final void set_nobleBoarder(ImageModel r100) {
        this._nobleBoarder = r100;
    }

    public final void set_nobleIcon(ImageModel r100) {
        this._nobleIcon = r100;
    }

    public final void set_nobleIconWithBack(ImageModel r100) {
        this._nobleIconWithBack = r100;
    }

    public final void set_nobleLevel(long r100) {
        this._nobleLevel = r100;
    }

    public final void set_nobleName(String r100) {
        this._nobleName = r100;
    }
}
