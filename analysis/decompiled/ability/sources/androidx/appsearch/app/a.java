package androidx.appsearch.app;

import androidx.appsearch.app.AppSearchSchema;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.android.LayoutIntrinsics;
import androidx.constraintlayout.core.utils.GridCore;
import java.util.Comparator;
import kotlin.Pair;
import z3.AbstractC2156a;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1700a;

    public /* synthetic */ a(int i) {
        this.f1700a = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f1700a) {
            case 0:
                return AppSearchSchema.lambda$appendAppSearchSchemaString$0((AppSearchSchema.PropertyConfig) obj, (AppSearchSchema.PropertyConfig) obj2);
            case 1:
                return LayoutNode.ZComparator$lambda$41((LayoutNode) obj, (LayoutNode) obj2);
            case 2:
                return LayoutIntrinsics.computeMinIntrinsicWidth$lambda$1((Pair) obj, (Pair) obj2);
            case 3:
                return GridCore.lambda$parseSpans$0((String) obj, (String) obj2);
            default:
                String strE = ((AbstractC2156a) obj).e();
                String strE2 = ((AbstractC2156a) obj2).e();
                if (!strE.equals(strE2)) {
                    if (!strE.equals("discriminator")) {
                        if (!strE2.equals("discriminator")) {
                            if (!strE.equals("type")) {
                                if (!strE2.equals("type")) {
                                    if (!strE.equals("properties")) {
                                        if (!strE2.equals("properties")) {
                                            if (!strE.equals("patternProperties")) {
                                                if (!strE2.equals("patternProperties") && !strE.equals("unevaluatedItems")) {
                                                    if (!strE2.equals("unevaluatedItems")) {
                                                        if (!strE.equals("unevaluatedProperties")) {
                                                            if (strE2.equals("unevaluatedProperties")) {
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        return 1;
                    }
                    return -1;
                }
                return 0;
        }
    }
}
