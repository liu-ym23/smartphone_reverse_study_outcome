package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LockFreeLinkedList.kt */
/* JADX INFO: loaded from: classes4.dex */
public class v extends x {
    @Override // kotlinx.coroutines.internal.x
    public boolean d() {
        return false;
    }

    public v() {
    }

    @Override // kotlinx.coroutines.internal.x
    public /* synthetic */ boolean e() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(c(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    public final Void c() {
        throw new IllegalStateException("head cannot be removed".toString());
    }
}
