package com.obric.autogui.operator.a.b.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.g;
import d.h.b.h;
import d.h.b.o;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ScrollWheelDebugHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    private static final String TAG = "ScrollWheelDebug";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f29631a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f29632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.f f29633c;

    /* JADX INFO: compiled from: ScrollWheelDebugHelper.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Float.valueOf(((d.f) ZeusTransformUtils.preCheckCast(r2, d.f.class, "com.obric.aiagent.plugin")).g()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Float.valueOf(((d.f) ZeusTransformUtils.preCheckCast(r3, d.f.class, "com.obric.aiagent.plugin")).g()), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f29631a = new a(null);
    }

    public static /* synthetic */ File lambda$Bf2SkWr97FQcgaZ2KvAylFdLit4(f r0) {
        return a(r0);
    }

    public f(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this.f29632b = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
        this.f29633c = g.a(new $$Lambda$f$Bf2SkWr97FQcgaZ2KvAylFdLit4(this));
    }

    private final File b() {
        return (File) ZeusTransformUtils.preCheckCast(this.f29633c.b(), File.class, "com.obric.aiagent.plugin");
    }

    private static final File a(f r3) {
        com.obric.autogui.session.a r0 = com.obric.autogui.session.c.f30777a.b();
        if (r0 == null) goto L9;
        com.obric.autogui.session.a.d r1 = r0.z();
        if (r1 == null) goto L9;
        File r2 = r1.b();
        if (r2 == null) goto L9;
        String r4 = r2.getAbsolutePath();
    L10:
        if (r4 != null) goto L12;
        r4 = r3.f29632b.getCacheDir().toString();
    L12:
        File r5 = new File(r4, "scroll_debug");
        if (r5.exists() == true) goto L15;
        r5.mkdirs();
        ILogDepend.Companion.i(TAG, "创建调试目录: " + r5.getAbsolutePath());
    L15:
        return r5;
    L9:
        r4 = null;
        goto L10
    }

    public final String a() {
        String r1 = b().getAbsolutePath();
        o.c(r1, "getAbsolutePath(...)");
        return r1;
    }

    public final void a(Bitmap r15, Bitmap r16, JSONArray r17, d.f r18, int r19, float r20, float r21, int r22, int r23, String r24) {
        o.e(r15, "originalBitmap");
        o.e(r16, "processedBitmap");
        o.e(r17, "ocrResults");
        o.e(r24, "purpose");
        String r13 = new SimpleDateFormat("HHmmss_SSS", Locale.getDefault()).format(new Date());     // Catch: Exception -> L5
        String r3 = d.o.o.a(r24, " ", "_", false, 4, null).toLowerCase(Locale.ROOT);     // Catch: Exception -> L5
        o.c(r3, "toLowerCase(...)");     // Catch: Exception -> L5
        a(r15, r3 + "_original_" + r13 + ".png");     // Catch: Exception -> L5
        a(r16, r3 + "_processed_" + r13 + ".png");     // Catch: Exception -> L5
        Bitmap r1 = b(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);     // Catch: Exception -> L5
        a(r1, r3 + "_comparison_" + r13 + ".png");     // Catch: Exception -> L5
        r1.recycle();     // Catch: Exception -> L5
        ILogDepend.Companion.d(TAG, r24 + " 调试图片已保存，时间戳: " + r13);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "保存 " + r24 + " 调试图片失败: " + e.getMessage());
    }

    public final void a(Bitmap r14, Bitmap r15, JSONArray r16, List<d.f> r17, float r18, float r19, int r20, int r21) {
        List<d.f> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
        o.e(r14, "originalBitmap");
        o.e(r15, "processedBitmap");
        o.e(r16, "ocrResults");
        o.e(r5, "allTextBlocks");
        String r12 = new SimpleDateFormat("HHmmss_SSS", Locale.getDefault()).format(new Date());     // Catch: Exception -> L5
        a(r14, "step_analysis_original_" + r12 + ".png");     // Catch: Exception -> L5
        a(r15, "step_analysis_processed_" + r12 + ".png");     // Catch: Exception -> L5
        Bitmap r1 = b(r14, r15, r16, r5, r18, r19, r20, r21);     // Catch: Exception -> L5
        a(r1, "step_analysis_comparison_" + r12 + ".png");     // Catch: Exception -> L5
        r1.recycle();     // Catch: Exception -> L5
        ILogDepend.Companion.d(TAG, "步长分析调试图片已保存，时间戳: " + r12);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "保存步长分析调试图片失败: " + e.getMessage());
    }

    private final void a(Bitmap r9, String r10) {
        File r2 = new File(b(), r10);     // Catch: Exception -> L13
        Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r2), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L13
        r9.compress(Bitmap.CompressFormat.PNG, 90, (OutputStream) ZeusTransformUtils.preCheckCast((FileOutputStream) ZeusTransformUtils.preCheckCast(r8, FileOutputStream.class, "com.obric.aiagent.plugin"), OutputStream.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
        d.f.c.a(r8, null);     // Catch: Exception -> L13
        ILogDepend.Companion.d(TAG, "调试图片已保存: " + r2.getAbsolutePath());     // Catch: Exception -> L13
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        d.f.c.a(r8, th);     // Catch: Exception -> L13
        throw th;     // Catch: Exception -> L13
    L13:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "保存调试图片失败: " + r10 + ", " + e.getMessage());
    }

    private final Bitmap b(Bitmap r20, Bitmap r21, JSONArray r22, d.f r23, int r24, float r25, float r26, int r27, int r28, String r29) {
        Bitmap r13 = Bitmap.createBitmap(r20.getWidth() * 2, r20.getHeight() + 150, Bitmap.Config.ARGB_8888);
        o.c(r13, "createBitmap(...)");
        Canvas r14 = new Canvas(r13);
        r14.drawColor(-1);
        r14.drawBitmap(r20, 0.0f, 0.0f, null);
        r14.drawBitmap(r21, r20.getWidth(), 0.0f, null);
        Paint r9 = new Paint();
        r9.setColor(-16776961);
        r9.setTextSize(20.0f);
        r9.setAntiAlias(true);
        Paint r7 = new Paint();
        r7.setColor(-65536);
        r7.setStyle(Paint.Style.STROKE);
        r7.setStrokeWidth(2.0f);
        r7.setAntiAlias(true);
        Paint r6 = new Paint();
        r6.setColor(-16711936);
        r6.setStyle(Paint.Style.STROKE);
        r6.setStrokeWidth(4.0f);
        r6.setAntiAlias(true);
        Paint r5 = new Paint();
        r5.setColor(-65281);
        r5.setStyle(Paint.Style.FILL);
        r5.setAntiAlias(true);
        a(r14, r22, 0.0f, r7, r9, r27, r28);
        a(r14, r22, r20.getWidth(), r7, r9, r27, r28);
        if (r23 == null) goto L5;
        int r3 = r23.b() - r27;
        int r4 = r23.c() - r28;
        float r8 = r3;
        float r10 = r4;
        float r11 = r23.d() - r27;
        float r12 = r23.e() - r28;
        r14.drawRect(r8, r10, r11, r12, r6);
        r14.drawRect(r8 + r20.getWidth(), r10, r11 + r20.getWidth(), r12, r6);
    L5:
        float r15 = r25 - r27;
        float r16 = r26 - r28;
        r14.drawCircle(r15, r16, 8.0f, r5);
        r14.drawCircle(r15 + r20.getWidth(), r16, 8.0f, r5);
        float r17 = r20.getHeight() + 30.0f;
        r14.drawText(String.valueOf(r29), 10.0f, r17, r9);
        float r18 = 25.0f + r17;
        r14.drawText("原始图片", 10.0f, r18, r9);
        r14.drawText("处理后图片", r20.getWidth() + 10.0f, r18, r9);
        float r19 = 50.0f + r17;
        r14.drawText("目标数字: " + r24, 10.0f, r19, r9);
        r14.drawText("目标点: (" + ((int) r25) + ", " + ((int) r26) + ')', 10.0f, 75.0f + r17, r9);
        if (r23 == null) goto L11;
        r14.drawText("识别文本: '" + r23.a() + '\'', 10.0f, 100.0f + r17, r9);
        boolean r30 = true;
        Object r0 = d.f.a(r23, false, 1, null);
        StringBuilder r1 = new StringBuilder().append("提取数字: ");
        if (r0 != null) goto L10;
        r0 = "无";
    L10:
        r14.drawText(r1.append(r0).toString(), r20.getWidth() + 10.0f, r19, r9);
    L12:
        Paint r2 = new Paint();
        r2.setColor(-16777216);
        r2.setTextSize(16.0f);
        r2.setAntiAlias(r30);
        r14.drawText("红色=OCR框 绿色=目标块 紫色=目标点", 10.0f, r17 + 125.0f, r2);
        return r13;
    L11:
        r30 = true;
        goto L12
    }

    private final Bitmap b(Bitmap r24, Bitmap r25, JSONArray r26, List<d.f> r27, float r28, float r29, int r30, int r31) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.aiagent.plugin");
        Bitmap r14 = Bitmap.createBitmap(r24.getWidth() * 2, r24.getHeight() + 120, Bitmap.Config.ARGB_8888);
        o.c(r14, "createBitmap(...)");
        Canvas r15 = new Canvas(r14);
        r15.drawColor(-1);
        r15.drawBitmap(r24, 0.0f, 0.0f, null);
        r15.drawBitmap(r25, r24.getWidth(), 0.0f, null);
        Paint r8 = new Paint();
        r8.setColor(-16776961);
        r8.setTextSize(20.0f);
        r8.setAntiAlias(true);
        Paint r6 = new Paint();
        r6.setColor(-65536);
        r6.setStyle(Paint.Style.STROKE);
        r6.setStrokeWidth(2.0f);
        r6.setAntiAlias(true);
        Paint r4 = new Paint();
        r4.setColor(-16711681);
        r4.setStyle(Paint.Style.STROKE);
        r4.setStrokeWidth(3.0f);
        r4.setAntiAlias(true);
        Paint r3 = new Paint();
        r3.setColor(-65281);
        r3.setStyle(Paint.Style.FILL);
        r3.setAntiAlias(true);
        a(r15, r26, 0.0f, r6, r8, r30, r31);
        a(r15, r26, r24.getWidth(), r6, r8, r30, r31);
        List r2 = p.a((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.aiagent.plugin"));
        int r9 = r2.size() - 1;
        int r5 = 0;
    L3:
        if (r5 >= r9) goto L5;
        d.f r7 = (d.f) ZeusTransformUtils.preCheckCast(r2.get(r5), d.f.class, "com.obric.aiagent.plugin");
        int r10 = r5 + 1;
        d.f r11 = (d.f) ZeusTransformUtils.preCheckCast(r2.get(r10), d.f.class, "com.obric.aiagent.plugin");
        float r13 = r31;
        float r16 = r7.g() - r13;
        float r20 = r11.g() - r13;
        float r21 = r24.getWidth() / 2.0f;
        r15.drawLine(r21, r16, r21, r20, r4);
        r15.drawLine(r21 + r24.getWidth(), r16, r21 + r24.getWidth(), r20, r4);
        r15.drawText(((int) Math.abs(r20 - r16)) + "px", r21 + 20, (r16 + r20) / 2, r8);
        r5 = r10;
        goto L3
    L5:
        float r17 = r28 - r30;
        float r18 = r29 - r31;
        r15.drawCircle(r17, r18, 8.0f, r3);
        r15.drawCircle(r17 + r24.getWidth(), r18, 8.0f, r3);
        float r19 = r24.getHeight() + 30.0f;
        r15.drawText("步长分析", 10.0f, r19, r8);
        float r22 = 25.0f + r19;
        r15.drawText("原始图片", 10.0f, r22, r8);
        r15.drawText("处理后图片", r24.getWidth() + 10.0f, r22, r8);
        float r23 = 50.0f + r19;
        r15.drawText("文本块数量: " + r12.size(), 10.0f, r23, r8);
        r15.drawText("中心点: (" + ((int) r28) + ", " + ((int) r29) + ')', r24.getWidth() + 10.0f, r23, r8);
        Paint r0 = new Paint();
        r0.setColor(-16777216);
        r0.setTextSize(16.0f);
        r0.setAntiAlias(true);
        r15.drawText("红色=OCR框 橙色=距离线 紫色=目标点", 10.0f, r19 + 75.0f, r0);
        return r14;
    }

    private final void a(Canvas r17, JSONArray r18, float r19, Paint r20, Paint r21, int r22, int r23) {
        int r1 = r18.length();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L15;
        JSONObject r0 = r18.getJSONObject(r3);     // Catch: Exception -> L11
        String r5 = r0.getString("text");     // Catch: Exception -> L11
        JSONArray r2 = r0.getJSONArray("region");     // Catch: Exception -> L11
        JSONArray r6 = r2.getJSONArray(0);     // Catch: Exception -> L11
        JSONArray r8 = r2.getJSONArray(1);     // Catch: Exception -> L11
        JSONArray r4 = r2.getJSONArray(3);     // Catch: Exception -> L11
        float r9 = r6.getInt(0) + r19;     // Catch: Exception -> L11
        float r7 = r6.getInt(1);     // Catch: Exception -> L11
        r17.drawRect(r9, r7, r8.getInt(0) + r19, r4.getInt(1), r20);     // Catch: Exception -> L11
        r17.drawText(r5, r9, r7 - 5.0f, r21);     // Catch: Exception -> L9
    L14:
        r3 = r3 + 1;
    L9:
        e = e;
    L13:
        ILogDepend.Companion.w(TAG, "绘制OCR结果失败: " + e.getMessage());
    L11:
        e = e;
        goto L13
    }
}
