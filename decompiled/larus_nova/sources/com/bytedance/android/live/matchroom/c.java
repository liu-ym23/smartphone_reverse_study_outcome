package com.bytedance.android.live.matchroom;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
public interface c {

    public static final class a {
        public static void b(c r210, Paint r211, float r212, float r213, String r214) {
            Intrinsics.checkNotNullParameter(r211, "paint");
            Intrinsics.checkNotNullParameter(r214, "logTag");
            if (r211.getShader() != null) goto L20;
            List r100 = StringsKt.split$default(r210.getInputColors(), new char[]{','}, false, 0, 6, null);     // Catch: Exception -> L14
            ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));     // Catch: Exception -> L14
            Iterator r102 = r100.iterator();     // Catch: Exception -> L14
        L6:
            if (r102.hasNext() == false) goto L8;
            r101.add(Integer.valueOf(Color.parseColor((String) r102.next())));     // Catch: Exception -> L14
            goto L6
        L8:
            int[] r110 = CollectionsKt.toIntArray(r101);     // Catch: Exception -> L14
            List r103 = StringsKt.split$default(r210.getInputPositions(), new char[]{','}, false, 0, 6, null);     // Catch: Exception -> L14
            ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));     // Catch: Exception -> L14
            Iterator r105 = r103.iterator();     // Catch: Exception -> L14
        L10:
            if (r105.hasNext() == false) goto L12;
            r104.add(Float.valueOf(CastFloatProtector.parseFloat((String) r105.next())));     // Catch: Exception -> L14
            goto L10
        L12:
            r211.setShader(new LinearGradient(0.0f, r212, r213, r212, r110, CollectionsKt.toFloatArray(r104), Shader.TileMode.CLAMP));     // Catch: Exception -> L14
            return;
        L14:
            ALogger.e(r214, "parse error for " + r210.getInputColors() + '-' + r210.getInputPositions());
            r210.setInputColors("#00000000,#26000000,#4D000000,#73000000,#99000000,#B2000000,#C7000000,#D9000000,#E5000000");
            r210.setInputPositions("0.0,0.11,0.21,0.32,0.45,0.58,0.7,0.84,1.0");
            return;
        }

        public static void a(c r100, Canvas r101, Paint r102, float r110, float r111, String r112) {
            Intrinsics.checkNotNullParameter(r102, "paint");
            Intrinsics.checkNotNullParameter(r112, "logTag");
            if (r100.getEnableShader() == false) goto L8;
            r100.Y0(r102, r110, r111, r112);
            if (r101 == null) goto L9;
            r101.drawRect(0.0f, 0.0f, r111, r110, r102);
            return;
        L9:
            return;
        }
    }

    void Y0(Paint r100, float r101, float r102, String r103);

    boolean getEnableShader();

    String getInputColors();

    String getInputPositions();

    void setInputColors(String r100);

    void setInputPositions(String r100);
}
