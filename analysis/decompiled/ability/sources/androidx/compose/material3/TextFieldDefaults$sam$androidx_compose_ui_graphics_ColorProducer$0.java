package androidx.compose.material3;

import C7.d;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0 implements ColorProducer, g {
    private final /* synthetic */ S7.a function;

    public TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0(S7.a aVar) {
        this.function = aVar;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof ColorProducer) && (obj instanceof g)) {
            return k.b(getFunctionDelegate(), ((g) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.g
    public final d getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // androidx.compose.ui.graphics.ColorProducer
    /* renamed from: invoke-0d7_KjU */
    public final /* synthetic */ long mo1813invoke0d7_KjU() {
        return ((Color) this.function.invoke()).m4149unboximpl();
    }
}
