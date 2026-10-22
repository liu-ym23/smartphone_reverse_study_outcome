package kotlin.reflect.jvm.internal.impl.renderer;

import j9.t;
import kotlin.enums.a;
import kotlin.jvm.internal.k;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public abstract class RenderingFormat {

    /* renamed from: a, reason: collision with root package name */
    public static final RenderingFormat f5113a;
    public static final RenderingFormat b;
    public static final /* synthetic */ RenderingFormat[] c;

    static {
        RenderingFormat renderingFormat = new RenderingFormat() { // from class: kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.PLAIN
            @Override // kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat
            public final String a(String string) {
                k.f(string, "string");
                return string;
            }
        };
        f5113a = renderingFormat;
        RenderingFormat renderingFormat2 = new RenderingFormat() { // from class: kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.HTML
            @Override // kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat
            public final String a(String string) {
                k.f(string, "string");
                return t.c0(t.c0(string, "<", "&lt;"), ">", "&gt;");
            }
        };
        b = renderingFormat2;
        RenderingFormat[] renderingFormatArr = {renderingFormat, renderingFormat2};
        c = renderingFormatArr;
        a.a(renderingFormatArr);
    }

    public static RenderingFormat valueOf(String str) {
        return (RenderingFormat) Enum.valueOf(RenderingFormat.class, str);
    }

    public static RenderingFormat[] values() {
        return (RenderingFormat[]) c.clone();
    }

    public abstract String a(String str);
}
