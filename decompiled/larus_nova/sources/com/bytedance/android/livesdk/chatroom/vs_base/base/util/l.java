package com.bytedance.android.livesdk.chatroom.vs_base.base.util;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.ReplayConfigSettingKeys;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VideoResolutionItem;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.nova.R;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.VideoRef;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes8.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<a> f117941a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f117942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f117943b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f117944c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f117942a, r101.f117942a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f117943b, r101.f117943b) == true) goto L10;
            return false;
        L10:
            if (this.f117944c == r101.f117944c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f117942a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f117943b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return ((r103 + r101) * 31) + this.f117944c;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "VSReplayResolution(key=" + this.f117942a + ", name=" + this.f117943b + ", icon=" + this.f117944c + ")";
        }

        public a(String r100, String r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "name");
            this.f117942a = r100;
            this.f117943b = r101;
            this.f117944c = r102;
        }
    }

    static {
        f117941a = CollectionsKt.listOf(new a[]{new a("240p", "流畅 240P", R.drawable.ttlive_icon_toolbar_resolution_ld), new a("360p", "标清 360P", R.drawable.ttlive_icon_toolbar_resolution_ld), new a("480p", "标清 480P", R.drawable.ttlive_icon_toolbar_resolution_ld), new a("540p", "高清 540P", R.drawable.ttlive_icon_toolbar_resolution_sd), new a("720p", "高清 720P", R.drawable.ttlive_icon_toolbar_resolution_sd), new a("1080p", "蓝光 1080P", R.drawable.ttlive_icon_toolbar_resolution_uhd), new a("1080p 50fps", "蓝光 1080P", R.drawable.ttlive_icon_toolbar_resolution_uhd), new a("1080p 60fps", "蓝光 1080P", R.drawable.ttlive_icon_toolbar_resolution_uhd), new a("1080p 120fps", "蓝光 1080P", R.drawable.ttlive_icon_toolbar_resolution_uhd), new a("2k", "2K", R.drawable.ttlive_icon_toolbar_resolution_uhd), new a("4k", "超高清 4K", R.drawable.ttlive_icon_toolbar_resolution_4k), new a("2k 50fps", "2K", R.drawable.ttlive_icon_toolbar_resolution_uhd), new a("4k 50fps", "超高清 4K", R.drawable.ttlive_icon_toolbar_resolution_4k), new a("2k 60fps", "2K", R.drawable.ttlive_icon_toolbar_resolution_uhd), new a("4k 60fps", "4K", R.drawable.ttlive_icon_toolbar_resolution_4k), new a("2k 120fps", "2K", R.drawable.ttlive_icon_toolbar_resolution_uhd), new a("4k 120fps", "4K", R.drawable.ttlive_icon_toolbar_resolution_4k), new a("hdr", "音画增强", R.drawable.ttlive_icon_toolbar_resolution_hdr_or_fhd)});
    }

    @JvmStatic
    public static final VideoResolutionItem b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "targetKey");
        Iterator<T> r101 = f117941a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(r100, ((a) r102).f117942a) == false) goto L4;
    L9:
        a r103 = (a) r102;
        if (r103 == null) goto L13;
        String r104 = r103.f117943b;
        if (r104 == null) goto L13;
    L15:
        return new VideoResolutionItem(r100, r104);
    L13:
        r104 = r100;
        goto L15
    L8:
        r102 = null;
        goto L9
    }

    @JvmStatic
    public static final boolean c(String r100) {
        ALogger.d("ReplayResolutionManager", "is HDR resolution:" + r100);
        if (Intrinsics.areEqual(r100, "hdr") == true) goto L18;
        Iterator<T> r101 = f117941a.iterator();
    L5:
        String r102 = null;
        if (r101.hasNext() == false) goto L10;
        Object r103 = r101.next();
        if (Intrinsics.areEqual(((a) r103).f117942a, "hdr") == false) goto L5;
    L11:
        a r104 = (a) r103;
        if (r104 == null) goto L15;
        r102 = r104.f117943b;
    L15:
        if (Intrinsics.areEqual(r100, r102) == true) goto L18;
        return false;
    L10:
        r103 = null;
    L18:
        return true;
    }

    @JvmStatic
    public static final Resolution a(Resolution[] r100, Context r101) {
        if (r101 == null) goto L4;
        if (r100 == null) goto L27;
        if (r100.length != 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == true) goto L27;
        SettingKey<oq1.f> r103 = ReplayConfigSettingKeys.LIVE_REPLAY_DEFAULT_RESOLUTION;
        String r104 = r103.getValue().b();
        String r105 = r103.getValue().a();
        int r106 = ita.i.f495747a;
        if (NetworkUtils.isWifi(r101) == true) goto L16;
        r104 = r105;
    L16:
        int r107 = r100.length;
        int r108 = 0;
    L17:
        if (r108 >= r107) goto L22;
        Resolution r109 = r100[r108];
        if (Intrinsics.areEqual(r109.toString(VideoRef.TYPE_VIDEO), r104) == true) goto L23;
        r108 = r108 + 1;
    L23:
        if (r109 == null) goto L25;
        return r109;
    L25:
        return r100[RangesKt.coerceAtLeast(r100.length - 1, 0)];
    L22:
        r109 = null;
        goto L23
    L9:
        r102 = false;
    L27:
        return Resolution.Standard;
    L4:
        return Resolution.Standard;
    }
}
