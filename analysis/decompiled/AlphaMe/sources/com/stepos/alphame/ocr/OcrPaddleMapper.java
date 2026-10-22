package com.stepos.alphame.ocr;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import com.stepos.alphame.ocr.model.LineResult;
import com.stepos.alphame.ocr.model.OCRResult;
import com.stepos.alphame.ocr.task.OcrTaskDetail;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u0004\u0018\u00010\n2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/stepos/alphame/ocr/OcrPaddleMapper;", "", "", "raw", "", "parseAngleOrZero", "(Ljava/lang/String;)I", "", "Landroid/graphics/Point;", "points", "Landroid/graphics/Rect;", "computeBoundingRect", "(Ljava/util/List;)Landroid/graphics/Rect;", "LV0/a;", "paddleResult", "Landroid/graphics/Bitmap;", "bitmap", "Lcom/stepos/alphame/ocr/task/OcrTaskDetail;", "task", "toOcrResultJson", "(LV0/a;Landroid/graphics/Bitmap;Lcom/stepos/alphame/ocr/task/OcrTaskDetail;)Ljava/lang/String;", "<init>", "()V", "app_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nOcrPaddleMapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OcrPaddleMapper.kt\ncom/stepos/alphame/ocr/OcrPaddleMapper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,73:1\n1549#2:74\n1620#2,2:75\n1549#2:77\n1620#2,3:78\n1622#2:81\n*S KotlinDebug\n*F\n+ 1 OcrPaddleMapper.kt\ncom/stepos/alphame/ocr/OcrPaddleMapper\n*L\n20#1:74\n20#1:75,2\n26#1:77\n26#1:78,3\n20#1:81\n*E\n"})
/* loaded from: classes.dex */
public final class OcrPaddleMapper {

    @NotNull
    public static final OcrPaddleMapper INSTANCE = new OcrPaddleMapper();

    private OcrPaddleMapper() {
    }

    private final Rect computeBoundingRect(List<? extends Point> points) {
        List<? extends Point> list = points;
        if (list != null && !list.isEmpty()) {
            int iMax = Integer.MIN_VALUE;
            int iMax2 = Integer.MIN_VALUE;
            int iMin = Integer.MAX_VALUE;
            int iMin2 = Integer.MAX_VALUE;
            for (Point point : points) {
                iMin = Math.min(iMin, point.x);
                iMin2 = Math.min(iMin2, point.y);
                iMax = Math.max(iMax, point.x);
                iMax2 = Math.max(iMax2, point.y);
            }
            if (iMin != Integer.MAX_VALUE && iMin2 != Integer.MAX_VALUE && iMax != Integer.MIN_VALUE && iMax2 != Integer.MIN_VALUE) {
                return new Rect(iMin, iMin2, iMax, iMax2);
            }
        }
        return null;
    }

    private final int parseAngleOrZero(String raw) {
        Integer intOrNull;
        if (raw == null || StringsKt.isBlank(raw) || (intOrNull = StringsKt.toIntOrNull(StringsKt.trim((CharSequence) raw).toString())) == null) {
            return 0;
        }
        return intOrNull.intValue();
    }

    @NotNull
    public final String toOcrResultJson(@NotNull V0.a paddleResult, @Nullable Bitmap bitmap, @NotNull OcrTaskDetail task) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(paddleResult, "paddleResult");
        Intrinsics.checkNotNullParameter(task, "task");
        ArrayList<U0.a> arrayList2 = paddleResult.f1931d;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.e(arrayList2));
        for (U0.a aVar : arrayList2) {
            LineResult lineResult = new LineResult();
            lineResult.setText(aVar.f1887c);
            lineResult.setConfidence(aVar.f1888d);
            lineResult.setAngle(INSTANCE.parseAngleOrZero(aVar.f1890f));
            ArrayList arrayList4 = aVar.f1885a;
            if (arrayList4 != null) {
                Intrinsics.checkNotNull(arrayList4);
                arrayList = new ArrayList(CollectionsKt.e(arrayList4));
                Iterator it = arrayList4.iterator();
                while (it.hasNext()) {
                    Point point = (Point) it.next();
                    arrayList.add(new Point(point.x, point.y));
                }
            } else {
                arrayList = null;
            }
            lineResult.setPoints(arrayList);
            List listEmptyList = aVar.f1886b;
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            lineResult.setLineIndex(new ArrayList<>(listEmptyList));
            lineResult.setPosition(INSTANCE.computeBoundingRect(arrayList));
            arrayList3.add(lineResult);
        }
        OCRResult oCRResult = new OCRResult();
        oCRResult.setResult(task.bitmapPath, arrayList3, null, paddleResult.f1928a, task.bitmapType, task.contentVersion, bitmap != null ? bitmap.getWidth() : 0, bitmap != null ? bitmap.getHeight() : 0);
        String jsonString = oCRResult.toJsonString();
        Intrinsics.checkNotNullExpressionValue(jsonString, "toJsonString(...)");
        return jsonString;
    }
}
