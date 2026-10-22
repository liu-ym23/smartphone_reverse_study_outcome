package cdb;

import com.bytedance.lark.pb.basic.v1.CardComponent;
import com.ss.android.lark.tangram.base.style.Value;
import com.ss.android.lark.tangram.base.style.ValueType;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f23421a = 0;

    static {
    }

    @JvmStatic
    public static final Value a(CardComponent.Value r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ValueType.a r101 = ValueType.Companion;
        int r102 = r100.type.getValue();
        r101.getClass();
        return new Value(ValueType.a.a(r102), r100.value);
    }
}
