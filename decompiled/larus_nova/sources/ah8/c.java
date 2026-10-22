package ah8;

import com.larus.bmhome.chat.api.WidgetRenderDelegate;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c extends xc8.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Message f3438e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f3438e, ((c) r100).f3438e) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f3438e.hashCode();
    }

    public final String toString() {
        return "WidgetCellState(widgetMessage=" + this.f3438e + ')';
    }

    @Override // xc8.b
    public final int d() {
        Integer r100 = WidgetRenderDelegate.f297181a.o(this.f563233a.getContent());
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public c(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "widgetMessage");
        super(r100);
        this.f3438e = r100;
    }
}
