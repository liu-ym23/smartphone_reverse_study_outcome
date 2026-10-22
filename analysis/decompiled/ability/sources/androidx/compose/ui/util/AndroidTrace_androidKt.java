package androidx.compose.ui.util;

import S7.a;
import android.os.Trace;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a,\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "sectionName", "Lkotlin/Function0;", "block", "trace", "(Ljava/lang/String;LS7/a;)Ljava/lang/Object;", "tag", "", "value", "LC7/r;", "traceValue", "(Ljava/lang/String;J)V", "ui-util"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AndroidTrace_androidKt {
    public static final <T> T trace(String str, a aVar) {
        Trace.beginSection(str);
        try {
            return (T) aVar.invoke();
        } finally {
            Trace.endSection();
        }
    }

    public static final void traceValue(String str, long j5) {
        Trace.setCounter(str, j5);
    }
}
