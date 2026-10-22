package com.bytedance.android.livesdk.chatroom.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.fresco.ImageNetworkRequestsMonitor;
import com.bytedance.android.livesdk.chatroom.utils.pngloader.FlexData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class a3 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f114402d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FlexData f114403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Rect f114404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f114405c;

    public static final class a {
        public static void a(View r100, py.k r101, b r102, float r103) {
            a3 r104 = new a3();
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.getUrls().isEmpty() == true) goto L19;
            r104.f114405c = (String) ListProtector.get(r101.getUrls(), 0);
            ImagePipeline r105 = Fresco.getImagePipeline();
            List<String> r106 = r101.getUrls();
            if (r106 != null) goto L10;
        L15:
            String r107 = null;
        L16:
            ImageRequestBuilder r108 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r107));
            new ImageNetworkRequestsMonitor().monitor(r108);
            Unit r109 = Unit.INSTANCE;
            r105.fetchEncodedImage(r108.build(), null).subscribe(new b3(r104, r102, r100, r103), UiThreadImmediateExecutorService.getInstance());
            return;
        L10:
            if ((!r106.isEmpty()) == true) goto L13;
            r106 = null;
        L13:
            if (r106 == null) goto L15;
            r107 = (String) ListProtector.get(r106, 0);
            goto L16
        }
    }

    public interface b {
        void a(NinePatchDrawable r100);

        void onFail();
    }

    static {
    }

    public static int c(int r100, int r101) {
        if (r100 >= 0) goto L4;
        return 0;
    L4:
        if (r100 > r101) goto L6;
        return r100;
    L6:
        return r101;
    }

    public a3() {
        this.f114404b = new Rect(0, 0, 0, 0);
    }

    public final void d(InputStream r100) {
        po1.d r101 = new po1.d(r100);     // Catch: Exception -> L4
        this.f114403a = r101.b();     // Catch: Exception -> L4
        r101.close();     // Catch: Exception -> L4
        r100.close();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        StringBuilder r102 = new StringBuilder("getXmpChunkFlexData PngLoader exception ");
        e.printStackTrace();
        r102.append(Unit.INSTANCE);
        e(r102.toString());
    }

    public final void e(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("errorMsg", r100);
        r101.put("image_url", this.f114405c);
        LiveTracingMonitor.EventModule r102 = LiveTracingMonitor.EventModule.common;
        SettingKey<Boolean> r103 = LiveTracingMonitor.f64909a;
        LiveTracingMonitor.e("ttlive_resizable_load_fail", r102, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, null, null, r101);
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0060: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:50331744), block:B:31:0x0060 */
    public final Pair b(String r100, float r101, boolean r102) {
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        InputStream r104 = null;
        if (r103 == false) goto L13;
        e("loadLocalResizableImg path is empty");
        return null;
    L13:
        this.f114405c = r100;
        PolarisFileInputStreamWrapper r105 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L34 Exception -> L36
        d(r105);     // Catch: Throwable -> L30 Exception -> L32
        Bitmap r106 = BitmapFactory.decodeFile(r100);     // Catch: Throwable -> L30 Exception -> L32
        if (r106 == null) goto L24;
        NinePatchDrawable r107 = a(r106, null, r101, r102);     // Catch: Throwable -> L30 Exception -> L32
        if (r107 == null) goto L22;
        Pair r108 = new Pair(r107, r106);     // Catch: Throwable -> L30 Exception -> L32
        r105.close();
        return r108;
    L22:
        r105.close();
        return null;
    L24:
        e("loadLocalResizableImg srcBitmap is null");     // Catch: Throwable -> L30 Exception -> L32
        r105.close();     // Catch: IOException -> L27
    L29:
        return null;
    L27:
        e = move-exception;
        e("loadLocalResizableImg " + e.getMessage() + '}');
    L32:
        e = e;
    L38:
        e("loadLocalResizableImg getImageFilePath " + e.getMessage());     // Catch: Throwable -> L30
        if (r105 != null) goto L53;
    L44:
        return null;
    L53:
        r105.close();     // Catch: IOException -> L42
    L42:
        e = move-exception;
        e("loadLocalResizableImg " + e.getMessage() + '}');
        goto L44
    L30:
        th = th;
        r104 = r4;
    L45:
        if (r104 != null) goto L55;
    L50:
        throw th;
    L55:
        r104.close();     // Catch: IOException -> L48
    L48:
        e = move-exception;
        e("loadLocalResizableImg " + e.getMessage() + '}');
    L36:
        e = e;
        r105 = null;
    L34:
        th = th;
        goto L45
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public final NinePatchDrawable a(Bitmap r210, View r211, float r212, boolean r213) {
        Intrinsics.checkNotNullParameter(r210, "srcBitmap");
        if (r212 <= 0) goto L5;
        float r100 = r212;
    L11:
        FlexData r101 = this.f114403a;
        if (r101 != null) goto L14;
    L16:
        boolean r102 = false;
    L17:
        if (r102 == true) goto L20;
        r101 = null;
    L20:
        if (r101 == null) goto L67;
        int r103 = (int) (r210.getWidth() * r100);
        int r104 = (int) (r210.getHeight() * r100);
        ArrayList r105 = new ArrayList();
        ArrayList r106 = new ArrayList();
        float[] r110 = r101.textSetting;
        float r107 = r103;
        this.f114404b.left = c((int) ((r110[2] / 100.0f) * r107), r103);
        this.f114404b.right = c((int) ((r110[3] / 100.0f) * r107), r103);
        float r111 = r104;
        this.f114404b.top = c((int) ((r110[0] / 100.0f) * r111), r104);
        this.f114404b.bottom = c((int) ((r110[1] / 100.0f) * r111), r104);
        float[] r108 = r101.flexSetting;
        float r112 = (r108[2] / 100.0f) * r107;
        float r109 = r107 - ((r108[3] / 100.0f) * r107);
        r105.add(Integer.valueOf((int) r112));
        r105.add(Integer.valueOf((int) r109));
        float r113 = (r108[0] / 100.0f) * r111;
        float r114 = r111 - ((r108[1] / 100.0f) * r111);
        r106.add(Integer.valueOf((int) r113));
        r106.add(Integer.valueOf((int) r114));
        if (r106.isEmpty() == false) goto L24;
    L26:
        boolean r115 = false;
    L27:
        if (r115 == false) goto L65;
        int r116 = r105.size();
        int r117 = r106.size();
        Integer r118 = (Integer) ListProtector.get(r105, 0);
        if (r118 != null) goto L32;
    L34:
        Integer r119 = (Integer) ListProtector.get(r105, r105.size() - 1);
        if (r119 != null) goto L38;
    L40:
        Integer r120 = (Integer) ListProtector.get(r106, 0);
        if (r120 != null) goto L44;
    L46:
        Integer r121 = (Integer) ListProtector.get(r106, r106.size() - 1);
        if (r121 != null) goto L50;
    L52:
        int r122 = r116 * r117;
        ByteBuffer r123 = ByteBuffer.allocate((((r105.size() + 8) + r106.size()) + r122) * 4).order(ByteOrder.nativeOrder());
        r123.put((byte) 1);
        r123.put((byte) r105.size());
        r123.put((byte) r106.size());
        r123.put((byte) r122);
        r123.putInt(0);
        r123.putInt(0);
        r123.putInt(this.f114404b.left);
        r123.putInt(this.f114404b.right);
        r123.putInt(this.f114404b.top);
        r123.putInt(this.f114404b.bottom);
        r123.putInt(0);
        Iterator r124 = r105.iterator();
    L54:
        if (r124.hasNext() == false) goto L56;
        r123.putInt(c(((Integer) r124.next()).intValue(), r103));
        goto L54
    L56:
        Iterator r125 = r106.iterator();
    L58:
        if (r125.hasNext() == false) goto L60;
        r123.putInt(c(((Integer) r125.next()).intValue(), r104));
        goto L58
    L60:
        int r126 = 0;
    L61:
        if (r126 >= r122) goto L63;
        r123.putInt(1);
        r126 = r126 + 1;
        goto L61
    L63:
        byte[] r127 = r123.array();
    L80:
        if (r127 == null) goto L82;
        boolean r128 = true;
    L83:
        if (r128 == false) goto L85;
        byte[] r214 = r127;
    L86:
        if (r214 == null) goto L95;
        int r129 = r210.getWidth();
        int r130 = r210.getHeight();
        Matrix r131 = new Matrix();
        r131.postScale(r100, r100);
        Unit r132 = Unit.INSTANCE;
        Bitmap r133 = Bitmap.createBitmap(r210, 0, 0, r129, r130, r131, true);
        if ((!Intrinsics.areEqual(r133, r210)) == false) goto L91;
        if (r213 == false) goto L91;
        r210.recycle();
    L91:
        NinePatchDrawable r134 = new NinePatchDrawable(com.bytedance.android.live.core.utils.s1.getResources(), r133, r214, this.f114404b, null);
        r134.setBounds(0, 0, r134.getIntrinsicWidth(), r134.getIntrinsicHeight());
        if (r211 == null) goto L94;
        r211.setBackground(r134);
        Rect r135 = this.f114404b;
        r211.setPadding(r135.left, r135.top, r135.right, r135.bottom);
    L94:
        return r134;
    L95:
        return null;
    L85:
        r214 = null;
        goto L86
    L82:
        r128 = false;
        goto L83
    L50:
        if (r121.intValue() != r104) goto L52;
        r117 = r117 - 1;
        goto L52
    L44:
        if (r120.intValue() != 0) goto L46;
        r117 = r117 - 1;
        goto L46
    L38:
        if (r119.intValue() != r103) goto L40;
        r116 = r116 - 1;
        goto L40
    L32:
        if (r118.intValue() != 0) goto L34;
        r116 = r116 - 1;
        goto L34
    L65:
        throw new IllegalArgumentException("Regions must not be empty!".toString());
    L24:
        if (r105.isEmpty() == true) goto L26;
        r115 = true;
        goto L27
    L67:
        if (r210.getNinePatchChunk() == null) goto L79;
        ByteBuffer r136 = ByteBuffer.wrap(r210.getNinePatchChunk()).order(ByteOrder.nativeOrder());
        if (r136 != null) goto L71;
    L73:
        boolean r137 = false;
    L74:
        if (r137 == true) goto L77;
        r136 = null;
    L77:
        if (r136 == null) goto L79;
        r136.get();
        r136.get();
        r136.get();
        r136.getInt();
        r136.getInt();
        this.f114404b.left = (int) (r136.getInt() * r100);
        this.f114404b.right = (int) (r136.getInt() * r100);
        this.f114404b.top = (int) (r136.getInt() * r100);
        this.f114404b.bottom = (int) (r136.getInt() * r100);
        goto L79
    L71:
        if (r136.get() == 0) goto L73;
        r137 = true;
    L79:
        r127 = a1.f(r210.getNinePatchChunk(), r100, false, false);
        goto L80
    L14:
        if (Build.VERSION.SDK_INT < 28) goto L16;
        r102 = true;
        goto L17
    L5:
        Resources r138 = com.bytedance.android.live.core.utils.s1.getResources();
        if (r138 == null) goto L10;
        DisplayMetrics r139 = WindowDisplayMetricsOverride.apply(r138, r138.getDisplayMetrics());
        if (r139 == null) goto L10;
        r100 = r139.density / 3.0f;
    L10:
        r100 = 1.0f;
        goto L11
    }
}
