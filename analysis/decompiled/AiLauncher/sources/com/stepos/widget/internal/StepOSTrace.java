package com.stepos.widget.internal;

import android.os.Trace;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"Lcom/stepos/widget/internal/StepOSTrace;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "", "name", "Lkotlin/Function0;", "block", "section", "(Ljava/lang/String;Lp9/a;)Ljava/lang/Object;", "", UxipConstants.f30680s, "LY8/t;", "counter", "(Ljava/lang/String;J)V", "PREFIX", "Ljava/lang/String;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSTrace {
    public static final StepOSTrace INSTANCE = new StepOSTrace();
    private static final String PREFIX = "StepOS:";

    private StepOSTrace() {
    }

    public final void counter(String name, long value) {
        p.i(name, "name");
        Trace.setCounter(PREFIX + name, value);
    }

    public final <T> T section(String name, InterfaceC5063a<? extends T> block) {
        p.i(name, "name");
        p.i(block, "block");
        Trace.beginSection(PREFIX + name);
        try {
            return block.invoke();
        } finally {
            n.b(1);
            Trace.endSection();
            n.a(1);
        }
    }
}
