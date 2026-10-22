package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.RoomFeedData.DrawerConfig")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0007'()*+,-B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig;", "", "()V", "arrowView", "Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$ArrowView;", "getArrowView", "()Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$ArrowView;", "setArrowView", "(Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$ArrowView;)V", "avatarArea", "Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$AvatarArea;", "getAvatarArea", "()Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$AvatarArea;", "setAvatarArea", "(Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$AvatarArea;)V", "entranceIcon", "Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$EntranceIcon;", "getEntranceIcon", "()Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$EntranceIcon;", "setEntranceIcon", "(Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$EntranceIcon;)V", "entranceLayout", "Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$EntranceLayout;", "getEntranceLayout", "()Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$EntranceLayout;", "setEntranceLayout", "(Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$EntranceLayout;)V", "entranceTitle", "Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$EntranceTitle;", "getEntranceTitle", "()Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$EntranceTitle;", "setEntranceTitle", "(Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$EntranceTitle;)V", "specialConfig", "Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$SpecialDrawerConfig;", "getSpecialConfig", "()Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$SpecialDrawerConfig;", "setSpecialConfig", "(Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$SpecialDrawerConfig;)V", "ArrowView", "AvatarArea", "EntranceIcon", "EntranceLayout", "EntranceTitle", "FreqInfo", "SpecialDrawerConfig", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DrawerConfig implements h {

    @SerializedName("arrow_view")
    protected ArrowView arrowView;

    @SerializedName("avatar_area")
    protected AvatarArea avatarArea;

    @SerializedName("entrance_icon")
    protected EntranceIcon entranceIcon;

    @SerializedName("entrance_layout")
    protected EntranceLayout entranceLayout;

    @SerializedName("entrace_title")
    protected EntranceTitle entranceTitle;

    @SerializedName("special_config")
    protected SpecialDrawerConfig specialConfig;

    @ProtoMessage("webcast.data.RoomFeedData.DrawerConfig.ArrowView")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$ArrowView;", "", "()V", RemoteMessageConst.Notification.VISIBILITY, "", "getVisibility", "()I", "setVisibility", "(I)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ArrowView implements h {

        @SerializedName(RemoteMessageConst.Notification.VISIBILITY)
        protected int visibility;

        public ArrowView() {
        }

        public final int getVisibility() {
            return this.visibility;
        }

        public ArrowView(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L9;
            if (r102 != 1) goto L7;
            this.visibility = r100.i();
            goto L3
        L7:
            am3.h.e(r100);
            goto L3
        L9:
            r100.d(r101);
        }

        public final void setVisibility(int r100) {
            this.visibility = r100;
        }
    }

    @ProtoMessage("webcast.data.RoomFeedData.DrawerConfig.AvatarArea")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$AvatarArea;", "", "()V", "canShowFollow", "", "getCanShowFollow", "()I", "setCanShowFollow", "(I)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AvatarArea implements h {

        @SerializedName("can_show_follow")
        protected int canShowFollow;

        public AvatarArea() {
        }

        public final int getCanShowFollow() {
            return this.canShowFollow;
        }

        public AvatarArea(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L9;
            if (r102 != 1) goto L7;
            this.canShowFollow = r100.i();
            goto L3
        L7:
            am3.h.e(r100);
            goto L3
        L9:
            r100.d(r101);
        }

        public final void setCanShowFollow(int r100) {
            this.canShowFollow = r100;
        }
    }

    @ProtoMessage("webcast.data.RoomFeedData.DrawerConfig.EntranceIcon")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$EntranceIcon;", "", "()V", "animShowMethod", "", "getAnimShowMethod", "()I", "setAnimShowMethod", "(I)V", "animStopMethod", "getAnimStopMethod", "setAnimStopMethod", "height", "", "getHeight", "()Ljava/lang/String;", "setHeight", "(Ljava/lang/String;)V", "image", "Lcom/bytedance/android/live/base/model/ImageModel;", "getImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setImage", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class EntranceIcon implements h {

        @SerializedName("anim_show_method")
        protected int animShowMethod;

        @SerializedName("anim_stop_method")
        protected int animStopMethod;

        @SerializedName("height")
        protected String height;

        @SerializedName("image")
        protected ImageModel image;

        public EntranceIcon() {
            this.height = "22";
        }

        public final int getAnimShowMethod() {
            return this.animShowMethod;
        }

        public final int getAnimStopMethod() {
            return this.animStopMethod;
        }

        public final String getHeight() {
            return this.height;
        }

        public final ImageModel getImage() {
            return this.image;
        }

        public EntranceIcon(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L18;
            if (r102 != 1) goto L8;
            this.image = x.a(r100);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.animShowMethod = r100.i();
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.animStopMethod = r100.i();
            goto L3
        L12:
            if (r102 != 4) goto L13;
            this.height = am3.h.c(r100);
            goto L3
        L13:
            am3.h.e(r100);
            goto L3
        L18:
            r100.d(r101);
            if (this.height != null) goto L37;
            this.height = "22";
            return;
        }

        public final void setAnimShowMethod(int r100) {
            this.animShowMethod = r100;
        }

        public final void setAnimStopMethod(int r100) {
            this.animStopMethod = r100;
        }

        public final void setHeight(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.height = r100;
        }

        public final void setImage(ImageModel r100) {
            this.image = r100;
        }
    }

    @ProtoMessage("webcast.data.RoomFeedData.DrawerConfig.EntranceLayout")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$EntranceLayout;", "", "()V", "layoutParams", "", "getLayoutParams", "()I", "setLayoutParams", "(I)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class EntranceLayout implements h {

        @SerializedName("layout_params")
        protected int layoutParams;

        public EntranceLayout() {
        }

        public final int getLayoutParams() {
            return this.layoutParams;
        }

        public EntranceLayout(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L9;
            if (r102 != 1) goto L7;
            this.layoutParams = r100.i();
            goto L3
        L7:
            am3.h.e(r100);
            goto L3
        L9:
            r100.d(r101);
        }

        public final void setLayoutParams(int r100) {
            this.layoutParams = r100;
        }
    }

    @ProtoMessage("webcast.data.RoomFeedData.DrawerConfig.EntranceTitle")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$EntranceTitle;", "", "()V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class EntranceTitle implements h {

        @SerializedName("text")
        protected String text;

        public EntranceTitle() {
        }

        public EntranceTitle(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L9;
            if (r102 != 1) goto L7;
            this.text = am3.h.c(r100);
            goto L3
        L7:
            am3.h.e(r100);
            goto L3
        L9:
            r100.d(r101);
        }

        public final String getText() {
            return this.text;
        }

        public final void setText(String r100) {
            this.text = r100;
        }
    }

    @ProtoMessage("webcast.data.RoomFeedData.DrawerConfig.FreqInfo")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$FreqInfo;", "", "()V", "freqInterval", "", "getFreqInterval", "()I", "setFreqInterval", "(I)V", "freqKey", "", "getFreqKey", "()Ljava/lang/String;", "setFreqKey", "(Ljava/lang/String;)V", "showDuration", "getShowDuration", "setShowDuration", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FreqInfo implements h {

        @SerializedName("freq_duration")
        protected int freqInterval;

        @SerializedName("freq_key")
        protected String freqKey;

        @SerializedName("show_duration")
        protected int showDuration;

        public FreqInfo() {
        }

        public final int getFreqInterval() {
            return this.freqInterval;
        }

        public final String getFreqKey() {
            return this.freqKey;
        }

        public final int getShowDuration() {
            return this.showDuration;
        }

        public FreqInfo(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L15;
            if (r102 != 1) goto L8;
            this.showDuration = r100.i();
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.freqKey = am3.h.c(r100);
            goto L3
        L10:
            if (r102 != 3) goto L11;
            this.freqInterval = r100.i();
            goto L3
        L11:
            am3.h.e(r100);
            goto L3
        L15:
            r100.d(r101);
        }

        public final void setFreqInterval(int r100) {
            this.freqInterval = r100;
        }

        public final void setFreqKey(String r100) {
            this.freqKey = r100;
        }

        public final void setShowDuration(int r100) {
            this.showDuration = r100;
        }
    }

    @ProtoMessage("webcast.data.RoomFeedData.DrawerConfig.SpecialConfig")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR \u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$SpecialDrawerConfig;", "", "()V", "currentScene", "", "getCurrentScene", "()Ljava/lang/String;", "setCurrentScene", "(Ljava/lang/String;)V", "defaultLiveTab", "", "getDefaultLiveTab", "()Ljava/lang/Integer;", "setDefaultLiveTab", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "freqInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$FreqInfo;", "getFreqInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$FreqInfo;", "setFreqInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$FreqInfo;)V", "insertRoomReason", "getInsertRoomReason", "setInsertRoomReason", "title", "Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$EntranceTitle;", "getTitle", "()Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$EntranceTitle;", d.f25925o, "(Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig$EntranceTitle;)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SpecialDrawerConfig implements h {

        @SerializedName("current_talent")
        protected String currentScene;

        @SerializedName("more_live_tab")
        protected Integer defaultLiveTab;

        @SerializedName("freq_info")
        protected FreqInfo freqInfo;

        @SerializedName("insert_room_reason")
        protected Integer insertRoomReason;

        @SerializedName("entrace_title")
        protected EntranceTitle title;

        public SpecialDrawerConfig() {
        }

        public final String getCurrentScene() {
            return this.currentScene;
        }

        public final Integer getDefaultLiveTab() {
            return this.defaultLiveTab;
        }

        public final FreqInfo getFreqInfo() {
            return this.freqInfo;
        }

        public final Integer getInsertRoomReason() {
            return this.insertRoomReason;
        }

        public final EntranceTitle getTitle() {
            return this.title;
        }

        public SpecialDrawerConfig(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L21;
            if (r102 != 1) goto L8;
            this.title = new EntranceTitle(r100);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.defaultLiveTab = Integer.valueOf(r100.i());
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.insertRoomReason = Integer.valueOf(r100.i());
            goto L3
        L12:
            if (r102 != 4) goto L14;
            this.freqInfo = new FreqInfo(r100);
            goto L3
        L14:
            if (r102 != 5) goto L15;
            this.currentScene = am3.h.c(r100);
            goto L3
        L15:
            am3.h.e(r100);
            goto L3
        L21:
            r100.d(r101);
        }

        public final void setCurrentScene(String r100) {
            this.currentScene = r100;
        }

        public final void setDefaultLiveTab(Integer r100) {
            this.defaultLiveTab = r100;
        }

        public final void setFreqInfo(FreqInfo r100) {
            this.freqInfo = r100;
        }

        public final void setInsertRoomReason(Integer r100) {
            this.insertRoomReason = r100;
        }

        public final void setTitle(EntranceTitle r100) {
            this.title = r100;
        }
    }

    public DrawerConfig() {
    }

    public DrawerConfig(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.specialConfig = new SpecialDrawerConfig(r100);
        goto L3
    L8:
        this.entranceLayout = new EntranceLayout(r100);
        goto L3
    L9:
        this.arrowView = new ArrowView(r100);
        goto L3
    L10:
        this.entranceTitle = new EntranceTitle(r100);
        goto L3
    L11:
        this.entranceIcon = new EntranceIcon(r100);
        goto L3
    L12:
        this.avatarArea = new AvatarArea(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
    }

    public final ArrowView getArrowView() {
        return this.arrowView;
    }

    public final AvatarArea getAvatarArea() {
        return this.avatarArea;
    }

    public final EntranceIcon getEntranceIcon() {
        return this.entranceIcon;
    }

    public final EntranceLayout getEntranceLayout() {
        return this.entranceLayout;
    }

    public final EntranceTitle getEntranceTitle() {
        return this.entranceTitle;
    }

    public final SpecialDrawerConfig getSpecialConfig() {
        return this.specialConfig;
    }

    public final void setArrowView(ArrowView r100) {
        this.arrowView = r100;
    }

    public final void setAvatarArea(AvatarArea r100) {
        this.avatarArea = r100;
    }

    public final void setEntranceIcon(EntranceIcon r100) {
        this.entranceIcon = r100;
    }

    public final void setEntranceLayout(EntranceLayout r100) {
        this.entranceLayout = r100;
    }

    public final void setEntranceTitle(EntranceTitle r100) {
        this.entranceTitle = r100;
    }

    public final void setSpecialConfig(SpecialDrawerConfig r100) {
        this.specialConfig = r100;
    }
}
