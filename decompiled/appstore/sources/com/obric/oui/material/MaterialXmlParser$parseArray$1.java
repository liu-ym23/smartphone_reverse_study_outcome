package com.obric.oui.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lorg/xmlpull/v1/XmlPullParser;", "parser", "", "Lcom/obric/oui/material/b;", "invoke", "(Lorg/xmlpull/v1/XmlPullParser;)[Lcom/obric/oui/material/b;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class MaterialXmlParser$parseArray$1 extends Lambda implements Function1<XmlPullParser, b[]> {
    public static final MaterialXmlParser$parseArray$1 INSTANCE = null;

    static {
        INSTANCE = new MaterialXmlParser$parseArray$1();
    }

    public MaterialXmlParser$parseArray$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ b[] invoke(XmlPullParser r10) {
        return invoke2(r10);
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final b[] invoke2(@NotNull XmlPullParser r10) {
        kotlin.jvm.internal.q.g(r10, "parser");
        MaterialXmlParser r11 = MaterialXmlParser.f15185a;
        String r12 = r10.getName();
        kotlin.jvm.internal.q.f(r12, "parser.name");
        if (kotlin.jvm.internal.q.b(MaterialXmlParser.a(r11, r12), "material_configs") == false) goto L6;
        return MaterialXmlParser.c(r11, r10);
    L6:
        return new b[]{MaterialXmlParser.b(r11, r10)};
    }
}
