package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\b\u001a\u00020\u0003J\u0006\u0010\t\u001a\u00020\u0003R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/GuestVoiceLiveThemeConfig;", "", "ugcThemeEnable", "", "ugcAnimateThemeEnable", "(ZZ)V", "GuestVoiceLiveThemeConfig", "", "isUgcAnimateThemeEnable", "isUgcThemeEnable", "Companion", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GuestVoiceLiveThemeConfig {
    public static final Companion Companion = null;

    @SerializedName("animate_theme_enable")
    public boolean ugcAnimateThemeEnable;

    @SerializedName("theme_enable")
    public boolean ugcThemeEnable;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/GuestVoiceLiveThemeConfig$Companion;", "", "()V", "defaultConfig", "Lcom/bytedance/android/livesdkapi/model/GuestVoiceLiveThemeConfig;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public final GuestVoiceLiveThemeConfig defaultConfig() {
            return new GuestVoiceLiveThemeConfig(false, false);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public GuestVoiceLiveThemeConfig() {
        boolean r100 = false;
        this(r100, r100, 3, null);
    }

    public final boolean isUgcAnimateThemeEnable() {
        return this.ugcAnimateThemeEnable;
    }

    public final boolean isUgcThemeEnable() {
        return this.ugcThemeEnable;
    }

    public GuestVoiceLiveThemeConfig(boolean r100, boolean r101) {
        this.ugcThemeEnable = r100;
        this.ugcAnimateThemeEnable = r101;
    }

    public final void GuestVoiceLiveThemeConfig(boolean r100, boolean r101) {
        this.ugcThemeEnable = r100;
        this.ugcAnimateThemeEnable = r101;
    }

    public /* synthetic */ GuestVoiceLiveThemeConfig(boolean r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}
