package c19;

import android.graphics.Path;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f22098a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f22099b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<String> f22100c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f22101d = null;

    static {
        f22098a = CollectionsKt.listOf(new String[]{"add", "arrow_left_bold", "close", "filetype_doc", "filetype_pdf", "play_circle", "search", "weather_rain", "weather_sunny"});
        f22099b = SetsKt.setOf(new String[]{"filetype_doc", "filetype_pdf", "weather_rain", "weather_sunny"});
        f22100c = SetsKt.emptySet();
        f22101d = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new e());
    }

    public static b a(int r210) {
        if ((r210 / 128) == 0) goto L5;
    L17:
        return null;
    L5:
        switch(r210) {
            case 0: goto L15;
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L19;
            default: goto L17;
        };
    L8:
        Path r100 = new Path();
        Intrinsics.checkNotNullParameter(r100, "p");
        r100.moveTo(13.86f, 2.96f);
        r100.cubicTo(17.21f, 2.96f, 19.94f, 5.39f, 20.07f, 8.43f);
        r100.cubicTo(20.07f, 8.54f, 20.12f, 8.65f, 20.19f, 8.73f);
        r100.cubicTo(20.97f, 9.61f, 21.44f, 10.76f, 21.44f, 12.03f);
        r100.cubicTo(21.44f, 14.77f, 19.22f, 17.0f, 16.47f, 17.0f);
        r100.lineTo(7.9f, 17.0f);
        r100.cubicTo(4.95f, 17.0f, 2.56f, 14.61f, 2.56f, 11.65f);
        r100.cubicTo(2.56f, 8.7f, 4.95f, 6.31f, 7.9f, 6.31f);
        r100.lineTo(7.92f, 6.31f);
        r100.cubicTo(8.08f, 6.31f, 8.24f, 6.21f, 8.32f, 6.07f);
        r100.cubicTo(9.35f, 4.22f, 11.44f, 2.96f, 13.86f, 2.96f);
        r100.close();
        r100.setFillType(Path.FillType.WINDING);
        Path r101 = new Path();
        Intrinsics.checkNotNullParameter(r101, "p");
        r101.moveTo(9.98f, 18.38f);
        r101.cubicTo(10.09f, 17.95f, 10.53f, 17.7f, 10.95f, 17.82f);
        r101.cubicTo(11.38f, 17.93f, 11.63f, 18.37f, 11.52f, 18.8f);
        r101.lineTo(10.77f, 21.58f);
        r101.cubicTo(10.66f, 22.0f, 10.22f, 22.26f, 9.8f, 22.14f);
        r101.cubicTo(9.37f, 22.03f, 9.12f, 21.59f, 9.23f, 21.16f);
        r101.lineTo(9.98f, 18.38f);
        r101.close();
        r101.setFillType(Path.FillType.WINDING);
        Path r102 = new Path();
        Intrinsics.checkNotNullParameter(r102, "p");
        r102.moveTo(13.23f, 18.38f);
        r102.cubicTo(13.34f, 17.95f, 13.78f, 17.7f, 14.2f, 17.82f);
        r102.cubicTo(14.63f, 17.93f, 14.88f, 18.37f, 14.77f, 18.8f);
        r102.lineTo(14.02f, 21.58f);
        r102.cubicTo(13.91f, 22.0f, 13.47f, 22.26f, 13.05f, 22.14f);
        r102.cubicTo(12.62f, 22.03f, 12.37f, 21.59f, 12.48f, 21.16f);
        r102.lineTo(13.23f, 18.38f);
        r102.close();
        r102.setFillType(Path.FillType.WINDING);
        return new b(CollectionsKt.listOf(new h[]{new h(r100, new d.a(12.0f, 2.95898f, 12.0f, 22.1694f, new float[]{1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f}, CollectionsKt.listOf(new j[]{new j(0.0f, CustomHeaderConfig.COLOR_LIGHT), new j(1.0f, "#F0F5FF")}))), new h(r101, new d.c("#BBDFFF")), new h(r102, new d.c("#BBDFFF"))}));
    L9:
        Path r103 = new Path();
        Intrinsics.checkNotNullParameter(r103, "p");
        r103.moveTo(10.26f, 1.7f);
        r103.cubicTo(14.96f, 1.7f, 18.76f, 5.5f, 18.76f, 10.2f);
        r103.cubicTo(18.76f, 11.99f, 18.21f, 13.65f, 17.26f, 15.02f);
        r103.lineTo(22.19f, 19.94f);
        r103.cubicTo(22.77f, 20.53f, 22.77f, 21.47f, 22.19f, 22.06f);
        r103.cubicTo(21.6f, 22.65f, 20.65f, 22.65f, 20.06f, 22.06f);
        r103.lineTo(15.15f, 17.15f);
        r103.cubicTo(13.77f, 18.12f, 12.08f, 18.7f, 10.26f, 18.7f);
        r103.cubicTo(5.57f, 18.7f, 1.76f, 14.89f, 1.76f, 10.2f);
        r103.cubicTo(1.76f, 5.5f, 5.57f, 1.7f, 10.26f, 1.7f);
        r103.close();
        Intrinsics.checkNotNullParameter(r103, "p");
        r103.moveTo(10.26f, 3.7f);
        r103.cubicTo(6.67f, 3.7f, 3.76f, 6.61f, 3.76f, 10.2f);
        r103.cubicTo(3.76f, 13.79f, 6.67f, 16.7f, 10.26f, 16.7f);
        r103.cubicTo(13.85f, 16.7f, 16.76f, 13.79f, 16.76f, 10.2f);
        r103.cubicTo(16.76f, 6.61f, 13.85f, 3.7f, 10.26f, 3.7f);
        r103.close();
        r103.setFillType(Path.FillType.WINDING);
        b r104 = new b(CollectionsKt.listOf(new h(r103, new d.C0389d())));
    L23:
        return r104;
    L10:
        Path r105 = new Path();
        Intrinsics.checkNotNullParameter(r105, "p");
        r105.moveTo(12.0f, 0.5f);
        r105.cubicTo(18.35f, 0.5f, 23.5f, 5.65f, 23.5f, 12.0f);
        r105.cubicTo(23.5f, 18.35f, 18.35f, 23.5f, 12.0f, 23.5f);
        r105.cubicTo(5.65f, 23.5f, 0.5f, 18.35f, 0.5f, 12.0f);
        r105.cubicTo(0.5f, 5.65f, 5.65f, 0.5f, 12.0f, 0.5f);
        r105.close();
        Intrinsics.checkNotNullParameter(r105, "p");
        r105.moveTo(12.0f, 2.5f);
        r105.cubicTo(6.75f, 2.5f, 2.5f, 6.75f, 2.5f, 12.0f);
        r105.cubicTo(2.5f, 17.25f, 6.75f, 21.5f, 12.0f, 21.5f);
        r105.cubicTo(17.25f, 21.5f, 21.5f, 17.25f, 21.5f, 12.0f);
        r105.cubicTo(21.5f, 6.75f, 17.25f, 2.5f, 12.0f, 2.5f);
        r105.close();
        Intrinsics.checkNotNullParameter(r105, "p");
        r105.moveTo(10.09f, 7.91f);
        r105.cubicTo(10.58f, 7.86f, 11.17f, 8.2f, 12.35f, 8.88f);
        r105.lineTo(14.15f, 9.92f);
        r105.cubicTo(15.33f, 10.6f, 15.92f, 10.94f, 16.12f, 11.39f);
        r105.cubicTo(16.29f, 11.78f, 16.29f, 12.22f, 16.12f, 12.61f);
        r105.cubicTo(15.92f, 13.06f, 15.33f, 13.4f, 14.15f, 14.08f);
        r105.lineTo(12.35f, 15.12f);
        r105.cubicTo(11.17f, 15.8f, 10.58f, 16.14f, 10.09f, 16.09f);
        r105.cubicTo(9.67f, 16.05f, 9.29f, 15.82f, 9.04f, 15.48f);
        r105.cubicTo(8.75f, 15.09f, 8.75f, 14.4f, 8.75f, 13.04f);
        r105.lineTo(8.75f, 10.96f);
        r105.cubicTo(8.75f, 9.6f, 8.75f, 8.91f, 9.04f, 8.52f);
        r105.cubicTo(9.29f, 8.18f, 9.67f, 7.95f, 10.09f, 7.91f);
        r105.close();
        r105.setFillType(Path.FillType.WINDING);
        r104 = new b(CollectionsKt.listOf(new h(r105, new d.C0389d())));
        goto L23
    L11:
        Path r106 = new Path();
        g.b(r106);
        r106.setFillType(Path.FillType.WINDING);
        Path r107 = new Path();
        g.b(r107);
        r107.setFillType(Path.FillType.WINDING);
        Path r108 = new Path();
        g.c(r108);
        g.a(r108);
        r108.setFillType(Path.FillType.WINDING);
        Path r110 = new Path();
        Intrinsics.checkNotNullParameter(r110, "p");
        r110.moveTo(13.71f, 13.79f);
        r110.cubicTo(14.36f, 14.35f, 15.15f, 14.65f, 15.98f, 14.71f);
        r110.cubicTo(16.5f, 14.71f, 17.51f, 14.71f, 17.51f, 13.67f);
        r110.cubicTo(17.54f, 13.27f, 17.33f, 12.6f, 15.89f, 12.57f);
        r110.cubicTo(15.25f, 12.57f, 14.6f, 12.66f, 13.96f, 12.78f);
        r110.cubicTo(13.19f, 12.08f, 12.55f, 11.25f, 12.06f, 10.33f);
        r110.cubicTo(12.58f, 8.62f, 12.61f, 7.45f, 12.21f, 6.9f);
        r110.cubicTo(12.03f, 6.66f, 11.72f, 6.5f, 11.42f, 6.5f);
        r110.cubicTo(11.02f, 6.47f, 10.65f, 6.66f, 10.47f, 6.99f);
        r110.cubicTo(9.92f, 7.91f, 10.71f, 9.72f, 11.08f, 10.45f);
        r110.cubicTo(10.65f, 11.77f, 10.13f, 13.03f, 9.46f, 14.25f);
        r110.cubicTo(6.55f, 15.51f, 6.49f, 16.27f, 6.49f, 16.55f);
        r110.cubicTo(6.49f, 16.89f, 6.67f, 17.22f, 7.01f, 17.38f);
        r110.cubicTo(7.13f, 17.47f, 7.31f, 17.5f, 7.47f, 17.5f);
        r110.cubicTo(8.23f, 17.5f, 9.12f, 16.64f, 10.07f, 14.96f);
        r110.cubicTo(11.26f, 14.47f, 12.46f, 14.07f, 13.71f, 13.79f);
        r110.close();
        Intrinsics.checkNotNullParameter(r110, "p");
        r110.moveTo(7.5f, 16.58f);
        r110.lineTo(7.4f, 16.61f);
        r110.cubicTo(7.68f, 16.21f, 8.05f, 15.91f, 8.51f, 15.72f);
        r110.cubicTo(8.26f, 16.12f, 7.93f, 16.43f, 7.5f, 16.58f);
        r110.close();
        Intrinsics.checkNotNullParameter(r110, "p");
        r110.moveTo(11.63f, 11.89f);
        r110.lineTo(11.66f, 11.93f);
        r110.lineTo(11.69f, 11.86f);
        r110.cubicTo(12.03f, 12.38f, 12.46f, 12.91f, 12.92f, 13.36f);
        r110.lineTo(12.83f, 13.36f);
        r110.lineTo(12.86f, 13.4f);
        r110.cubicTo(12.18f, 13.55f, 11.45f, 13.76f, 10.77f, 14.01f);
        r110.lineTo(10.77f, 13.95f);
        r110.lineTo(10.71f, 13.98f);
        r110.cubicTo(11.05f, 13.3f, 11.36f, 12.6f, 11.63f, 11.89f);
        r110.close();
        Intrinsics.checkNotNullParameter(r110, "p");
        r110.moveTo(15.06f, 13.55f);
        r110.cubicTo(15.34f, 13.49f, 15.58f, 13.49f, 15.86f, 13.49f);
        r110.cubicTo(16.47f, 13.49f, 16.66f, 13.63f, 16.59f, 13.73f);
        r110.cubicTo(16.53f, 13.84f, 16.2f, 13.82f, 15.98f, 13.79f);
        r110.cubicTo(15.67f, 13.76f, 15.37f, 13.7f, 15.06f, 13.55f);
        r110.close();
        Intrinsics.checkNotNullParameter(r110, "p");
        r110.moveTo(11.45f, 9.02f);
        r110.cubicTo(11.23f, 8.52f, 11.16f, 7.9f, 11.26f, 7.45f);
        r110.cubicTo(11.3f, 7.31f, 11.42f, 7.24f, 11.48f, 7.42f);
        r110.cubicTo(11.61f, 7.81f, 11.63f, 8.49f, 11.45f, 9.02f);
        r110.close();
        r110.setFillType(Path.FillType.EVEN_ODD);
        return new b(CollectionsKt.listOf(new h[]{new h(r106, new d.a(3.20505f, 1.70061f, 11.9314f, 22.7784f, new float[]{1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f}, CollectionsKt.listOf(new j[]{new j(0.0f, "#EBF1FF"), new j(1.0f, CustomHeaderConfig.COLOR_LIGHT)}))), new h(r107, new d.a(4.86077f, 1.49464f, 11.9413f, 22.7696f, new float[]{1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f}, CollectionsKt.listOf(new j[]{new j(0.0f, "#FFF2F1"), new j(1.0f, CustomHeaderConfig.COLOR_LIGHT)}))), new h(r108, new d.c("#FFD5D2")), new h(r110, new d.c("#E63F33"))}));
    L12:
        Path r109 = new Path();
        g.b(r109);
        r109.setFillType(Path.FillType.WINDING);
        Path r111 = new Path();
        Intrinsics.checkNotNullParameter(r111, "p");
        r111.moveTo(12.68f, 9.21f);
        r111.cubicTo(12.97f, 9.27f, 13.19f, 9.51f, 13.23f, 9.81f);
        r111.lineTo(13.79f, 14.2f);
        r111.lineTo(16.24f, 9.57f);
        r111.cubicTo(16.42f, 9.23f, 16.85f, 9.1f, 17.19f, 9.28f);
        r111.cubicTo(17.53f, 9.46f, 17.66f, 9.88f, 17.48f, 10.22f);
        r111.lineTo(14.0f, 16.81f);
        r111.cubicTo(13.86f, 17.07f, 13.56f, 17.22f, 13.26f, 17.17f);
        r111.cubicTo(12.96f, 17.11f, 12.73f, 16.87f, 12.69f, 16.57f);
        r111.lineTo(12.1f, 11.99f);
        r111.lineTo(9.19f, 16.84f);
        r111.cubicTo(9.03f, 17.1f, 8.73f, 17.23f, 8.43f, 17.16f);
        r111.cubicTo(8.13f, 17.09f, 7.92f, 16.84f, 7.89f, 16.54f);
        r111.lineTo(7.33f, 9.96f);
        r111.cubicTo(7.29f, 9.57f, 7.58f, 9.23f, 7.96f, 9.2f);
        r111.cubicTo(8.35f, 9.17f, 8.69f, 9.45f, 8.72f, 9.84f);
        r111.lineTo(9.1f, 14.26f);
        r111.lineTo(11.94f, 9.54f);
        r111.lineTo(12.0f, 9.45f);
        r111.cubicTo(12.16f, 9.25f, 12.42f, 9.16f, 12.68f, 9.21f);
        r111.close();
        r111.setFillType(Path.FillType.WINDING);
        Path r112 = new Path();
        g.c(r112);
        g.a(r112);
        r112.setFillType(Path.FillType.WINDING);
        return new b(CollectionsKt.listOf(new h[]{new h(r109, new d.a(4.86077f, 1.49464f, 11.9413f, 22.7696f, new float[]{1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f}, CollectionsKt.listOf(new j[]{new j(0.0f, "#EBF3FF"), new j(1.0f, CustomHeaderConfig.COLOR_LIGHT)}))), new h(r111, new d.c("#076FFF")), new h(r112, new d.c("#C6DEFF"))}));
    L13:
        Path r113 = new Path();
        Intrinsics.checkNotNullParameter(r113, "p");
        r113.moveTo(19.48f, 4.52f);
        r113.cubicTo(19.87f, 4.91f, 19.87f, 5.54f, 19.48f, 5.93f);
        r113.lineTo(13.42f, 11.99f);
        r113.lineTo(19.48f, 18.06f);
        r113.cubicTo(19.87f, 18.45f, 19.87f, 19.08f, 19.48f, 19.47f);
        r113.cubicTo(19.09f, 19.86f, 18.46f, 19.86f, 18.07f, 19.47f);
        r113.lineTo(12.0f, 13.41f);
        r113.lineTo(5.94f, 19.48f);
        r113.cubicTo(5.54f, 19.87f, 4.91f, 19.87f, 4.52f, 19.48f);
        r113.cubicTo(4.13f, 19.09f, 4.13f, 18.45f, 4.52f, 18.06f);
        r113.lineTo(10.59f, 11.99f);
        r113.lineTo(4.52f, 5.93f);
        r113.cubicTo(4.13f, 5.54f, 4.13f, 4.91f, 4.52f, 4.52f);
        r113.cubicTo(4.92f, 4.12f, 5.55f, 4.12f, 5.94f, 4.52f);
        r113.lineTo(12.0f, 10.58f);
        r113.lineTo(18.07f, 4.52f);
        r113.cubicTo(18.46f, 4.13f, 19.09f, 4.13f, 19.48f, 4.52f);
        r113.close();
        r113.setFillType(Path.FillType.WINDING);
        r104 = new b(CollectionsKt.listOf(new h(r113, new d.C0389d())));
        goto L23
    L14:
        Path r114 = new Path();
        Intrinsics.checkNotNullParameter(r114, "p");
        r114.moveTo(14.87f, 2.18f);
        r114.cubicTo(15.34f, 1.71f, 16.1f, 1.71f, 16.57f, 2.18f);
        r114.cubicTo(17.04f, 2.65f, 17.04f, 3.41f, 16.57f, 3.88f);
        r114.lineTo(8.45f, 12.0f);
        r114.lineTo(16.57f, 20.12f);
        r114.cubicTo(17.04f, 20.59f, 17.04f, 21.35f, 16.57f, 21.82f);
        r114.cubicTo(16.1f, 22.29f, 15.34f, 22.29f, 14.87f, 21.82f);
        r114.lineTo(6.75f, 13.7f);
        r114.cubicTo(5.81f, 12.76f, 5.81f, 11.24f, 6.75f, 10.3f);
        r114.lineTo(14.87f, 2.18f);
        r114.close();
        r114.setFillType(Path.FillType.WINDING);
        r104 = new b(CollectionsKt.listOf(new h(r114, new d.C0389d())));
        goto L23
    L15:
        Path r115 = new Path();
        Intrinsics.checkNotNullParameter(r115, "p");
        r115.moveTo(12.0f, 2.25f);
        r115.cubicTo(12.55f, 2.25f, 13.0f, 2.7f, 13.0f, 3.25f);
        r115.lineTo(13.0f, 11.0f);
        r115.lineTo(20.75f, 11.0f);
        r115.cubicTo(21.3f, 11.0f, 21.75f, 11.44f, 21.75f, 12.0f);
        r115.cubicTo(21.75f, 12.55f, 21.3f, 13.0f, 20.75f, 13.0f);
        r115.lineTo(13.0f, 13.0f);
        r115.lineTo(13.0f, 20.75f);
        r115.cubicTo(13.0f, 21.3f, 12.55f, 21.75f, 12.0f, 21.75f);
        r115.cubicTo(11.45f, 21.75f, 11.0f, 21.3f, 11.0f, 20.75f);
        r115.lineTo(11.0f, 13.0f);
        r115.lineTo(3.25f, 13.0f);
        r115.cubicTo(2.7f, 12.99f, 2.25f, 12.55f, 2.25f, 12.0f);
        r115.cubicTo(2.25f, 11.44f, 2.7f, 11.0f, 3.25f, 11.0f);
        r115.lineTo(11.0f, 11.0f);
        r115.lineTo(11.0f, 3.25f);
        r115.cubicTo(11.0f, 2.7f, 11.45f, 2.25f, 12.0f, 2.25f);
        r115.close();
        r115.setFillType(Path.FillType.WINDING);
        r104 = new b(CollectionsKt.listOf(new h(r115, new d.C0389d())));
        goto L23
    L19:
        return i.a();
    }
}
