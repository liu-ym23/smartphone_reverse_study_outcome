package com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.chatroom.utils.s0;
import com.bytedance.live.richcontent.model.style.ImageStyle;
import com.bytedance.live.richcontent.resource.cache.ResourceCache$CacheType;
import com.bytedance.live.richcontent.resource.cache.ResourceCache$ReferenceType;
import io.reactivex.Observable;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes9.dex */
public final class LiveImageResourceLoader implements hk6.a<ob2.c>, hk6.c<ob2.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.live.richcontent.resource.cache.b f140965a;

    public LiveImageResourceLoader() {
        int r100 = (com.bytedance.android.livesdk.interactivity.service.richcontent.a.f140945c * 1024) * 1024;
        LiveImageResourceLoader$bitmapCacheManager$1 r101 = LiveImageResourceLoader$bitmapCacheManager$1.INSTANCE;
        int r102 = com.bytedance.live.richcontent.resource.cache.f.f255801a;
        Intrinsics.checkNotNullParameter("LiveImageResourceLoader", "tag");
        Intrinsics.checkNotNullParameter(r101, "getEntitySize");
        this.f140965a = new com.bytedance.live.richcontent.resource.cache.b("LiveImageResourceLoader", ResourceCache$CacheType.MaxMemorySize, ResourceCache$ReferenceType.StrongReference, r100, r101);
    }

    public static ImageStyle.AdjustType d(ek6.d r100) {
        if ((r100 instanceof fk6.a) == true) goto L5;
        r100 = null;
    L5:
        fk6.a r101 = (fk6.a) r100;
        if (r101 == null) goto L11;
        ImageStyle r102 = r101.e();
        if (r102 != null) goto L10;
        return null;
    L10:
        return r102.f255752a;
    L11:
        return null;
    }

    public static Integer f(ek6.d r100) {
        if ((r100 instanceof fk6.a) == true) goto L5;
        r100 = null;
    L5:
        fk6.a r101 = (fk6.a) r100;
        if (r101 == null) goto L11;
        ImageStyle r102 = r101.e();
        if (r102 != null) goto L10;
        return null;
    L10:
        return Integer.valueOf(r102.f255753b);
    L11:
        return null;
    }

    public static Integer g(ek6.d r100) {
        if ((r100 instanceof fk6.a) == true) goto L5;
        r100 = null;
    L5:
        fk6.a r101 = (fk6.a) r100;
        if (r101 == null) goto L11;
        ImageStyle r102 = r101.e();
        if (r102 != null) goto L10;
        return null;
    L10:
        return Integer.valueOf(r102.f255754c);
    L11:
        return null;
    }

    public static String e(ob2.c r100, ek6.d r101) {
        String r102 = (String) CollectionsKt.firstOrNull(r100.f522596a);
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102 + Typography.amp + d(r101) + Typography.amp + f(r101) + Typography.amp + g(r101);
    }

    public static Observable h(ob2.c r100, ek6.d r101) {
        py.k r102 = (py.k) vh7.f.c(py.k.class);
        r102.setUrls(r100.f522596a);
        int r103 = 0;
        if (com.bytedance.android.livesdk.interactivity.service.richcontent.a.f140943a == true) goto L5;
    L13:
        int r104 = 0;
    L15:
        return Observable.create(new s0(r102, r103, r104));
    L5:
        if (d(r101) != ImageStyle.AdjustType.EXACTLY) goto L13;
        Integer r105 = f(r101);
        if (r105 == null) goto L9;
        r104 = r105.intValue();
    L10:
        Integer r106 = g(r101);
        if (r106 == null) goto L15;
        r103 = r106.intValue();
        goto L15
    L9:
        r104 = 0;
        goto L10
    }

    @Override // hk6.c
    public final Drawable b(ek6.b r110, ak6.f r111, ek6.d r112) {
        ob2.c r113 = (ob2.c) r110;
        Intrinsics.checkNotNullParameter(r113, "resource");
        Intrinsics.checkNotNullParameter(r111, "loadConfig");
        Intrinsics.checkNotNullParameter(r112, "content");
        boolean r100 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        List<String> r101 = ((ca0.j) com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class)).convertRichContentImageUrls(r113.f522596a);
        List<String> r102 = r101;
        boolean r103 = false;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L11;
        r113 = new ob2.c(r101, r113.f522597b);
    L11:
        boolean r105 = r111 instanceof com.bytedance.android.livesdk.interactivity.service.richcontent.config.b;
        if (r105 == true) goto L14;
        ak6.f r106 = null;
    L15:
        com.bytedance.android.livesdk.interactivity.service.richcontent.config.b r107 = (com.bytedance.android.livesdk.interactivity.service.richcontent.config.b) r106;
        if (r107 == null) goto L18;
        boolean r108 = r107.f140961e;
    L19:
        if (r108 == false) goto L26;
        String r109 = e(r113, r112);
        if (r109 == null) goto L23;
        Bitmap r114 = (Bitmap) this.f140965a.b(r109);
    L24:
        if (r114 == null) goto L27;
        boolean r115 = true;
    L28:
        if (r114 != null) goto L94;
        if (r105 == true) goto L31;
        ak6.f r116 = null;
    L32:
        com.bytedance.android.livesdk.interactivity.service.richcontent.config.b r117 = (com.bytedance.android.livesdk.interactivity.service.richcontent.config.b) r116;
        if (r117 == null) goto L35;
        r103 = r117.f140962f;
    L35:
        if (r103 == false) goto L94;
        py.k r118 = (py.k) vh7.f.c(py.k.class);
        r118.setUrls(r113.f522596a);
        IHostFrescoHelper r119 = (IHostFrescoHelper) jc1.k.f(IHostFrescoHelper.class);
        if (r119 == null) goto L39;
        String r120 = r119.getImageFilePath(r118);
    L40:
        if (r120 != null) goto L42;
    L93:
        r114 = null;
        goto L94
    L42:
        if (TextUtils.isEmpty(r120) == true) goto L93;
        if (com.bytedance.android.livesdk.interactivity.service.richcontent.a.f140943a == false) goto L86;
        ImageStyle.AdjustType r121 = d(r112);
        if (r121 == null) goto L86;
        Integer r122 = f(r112);
        if (r122 == null) goto L86;
        int r123 = r122.intValue();
        Integer r124 = g(r112);
        if (r124 == null) goto L86;
        int r125 = r124.intValue();
        ImageStyle.AdjustType r126 = ImageStyle.AdjustType.EXACTLY;
        if (r121 != r126) goto L57;
    L61:
        BitmapFactory.Options r127 = new BitmapFactory.Options();
        r127.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r120, r127);
        int r128 = r127.outHeight;
        int r129 = r127.outWidth;
        if (r128 <= 0) goto L86;
        if (r129 <= 0) goto L86;
        if (r123 <= 0) goto L76;
        if (r121 != r126) goto L68;
    L69:
        if (r128 <= r123) goto L74;
        int r130 = 1;
    L72:
        if (((r128 / 2) / r130) < r123) goto L75;
        r130 = r130 * 2;
    L75:
        Integer r131 = Integer.valueOf(r130);
    L87:
        if (r131 != null) goto L89;
    L91:
        BitmapFactory.Options r132 = null;
    L92:
        r114 = BitmapFactory.decodeFile(r120, r132);
        goto L94
    L89:
        if (r131.intValue() <= 1) goto L91;
        r132 = new BitmapFactory.Options();
        r132.inSampleSize = r131.intValue();
        goto L92
    L74:
        r130 = 1;
        goto L75
    L68:
        if (r121 == ImageStyle.AdjustType.ADJUST_HEIGHT) goto L69;
    L76:
        if (r125 <= 0) goto L86;
        if (r121 != ImageStyle.AdjustType.ADJUST_WIDTH) goto L86;
        if (r129 <= r125) goto L84;
        int r133 = 1;
    L82:
        if (((r129 / 2) / r133) < r125) goto L85;
        r133 = r133 * 2;
    L85:
        r131 = Integer.valueOf(r133);
        goto L87
    L84:
        r133 = 1;
        goto L85
    L57:
        if (r121 == ImageStyle.AdjustType.ADJUST_WIDTH) goto L61;
        if (r121 == ImageStyle.AdjustType.ADJUST_HEIGHT) goto L61;
    L86:
        r131 = null;
        goto L87
    L39:
        r120 = null;
        goto L40
    L31:
        r116 = r111;
    L94:
        if (r114 == null) goto L99;
        if (r115 == true) goto L99;
        if (com.bytedance.android.livesdk.interactivity.service.richcontent.config.c.a(r111) == false) goto L99;
        c(r114, r113, r112);
    L99:
        if (r114 != null) goto L101;
        return null;
    L101:
        return new BitmapDrawable(s1.getResources(), r114);
    L27:
        r115 = false;
        goto L28
    L23:
        r114 = null;
        goto L24
    L26:
        r114 = null;
        goto L27
    L18:
        r108 = false;
        goto L19
    L14:
        r106 = r111;
        goto L15
    L5:
        if (r102.isEmpty() == true) goto L8;
        r104 = false;
        goto L9
    }

    public final void c(Bitmap r100, ob2.c r101, ek6.d r102) {
        if (com.bytedance.android.livesdk.interactivity.service.richcontent.a.f140944b == true) goto L5;
        return;
    L5:
        String r103 = e(r101, r102);
        if (r103 != null) goto L8;
        return;
    L8:
        int r104 = r100.getAllocationByteCount();
        if (r104 > 0) goto L11;
        return;
    L11:
        if (r104 > (com.bytedance.android.livesdk.interactivity.service.richcontent.a.f140946d * 1024)) goto L16;
        this.f140965a.a(r103, r100);
        return;
    }

    @Override // hk6.a
    public final void a(ek6.b r110, ak6.f r111, ek6.d r112, hk6.d r113) {
        ob2.c r114 = (ob2.c) r110;
        Intrinsics.checkNotNullParameter(r114, "resource");
        Intrinsics.checkNotNullParameter(r111, "loadConfig");
        Intrinsics.checkNotNullParameter(r112, "content");
        Intrinsics.checkNotNullParameter(r113, "callback");
        boolean r100 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        List<String> r101 = ((ca0.j) com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class)).convertRichContentImageUrls(r114.f522596a);
        List<String> r102 = r101;
        boolean r103 = false;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L11;
        r114 = new ob2.c(r101, r114.f522597b);
    L11:
        Bitmap r105 = null;
        if ((r111 instanceof com.bytedance.android.livesdk.interactivity.service.richcontent.config.b) == true) goto L14;
        ak6.f r106 = null;
    L15:
        com.bytedance.android.livesdk.interactivity.service.richcontent.config.b r107 = (com.bytedance.android.livesdk.interactivity.service.richcontent.config.b) r106;
        if (r107 == null) goto L18;
        r103 = r107.f140963g;
    L18:
        if (r103 == false) goto L22;
        String r108 = e(r114, r112);
        if (r108 == null) goto L22;
        r105 = (Bitmap) this.f140965a.b(r108);
    L22:
        if (r105 == null) goto L25;
        r113.b(new BitmapDrawable(s1.getResources(), r105));
        return;
    L25:
        if (r114.f522597b == null) goto L27;
        h(r114, r112).subscribe(new c(this, r111, r114, r112, r113), new d(r114, r113));
        return;
    L27:
        h(r114, r112).subscribe(new e(this, r111, r114, r112, r113), new f(r113));
        return;
    L14:
        r106 = r111;
        goto L15
    L5:
        if (r102.isEmpty() == true) goto L8;
        r104 = false;
        goto L9
    }
}
