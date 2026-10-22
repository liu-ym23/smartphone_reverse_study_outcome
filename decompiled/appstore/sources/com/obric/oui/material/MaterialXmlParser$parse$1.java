package com.obric.oui.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lorg/xmlpull/v1/XmlPullParser;", "parser", "Lcom/obric/oui/material/b;", "invoke", "(Lorg/xmlpull/v1/XmlPullParser;)Lcom/obric/oui/material/b;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class MaterialXmlParser$parse$1 extends Lambda implements Function1<XmlPullParser, b> {
    public static final MaterialXmlParser$parse$1 INSTANCE = null;

    static {
        INSTANCE = new MaterialXmlParser$parse$1();
    }

    public MaterialXmlParser$parse$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ b invoke(XmlPullParser r10) {
        return invoke2(r10);
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final b invoke2(@NotNull XmlPullParser r10) {
        kotlin.jvm.internal.q.g(r10, "parser");
        return MaterialXmlParser.b(MaterialXmlParser.f15185a, r10);
    }
}
