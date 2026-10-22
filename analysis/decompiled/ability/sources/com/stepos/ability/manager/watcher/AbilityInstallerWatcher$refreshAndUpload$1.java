package com.stepos.ability.manager.watcher;

import C7.r;
import J7.c;
import S7.n;
import android.content.Context;
import com.stepos.ability.commoninternal.AppInfoUtils;
import com.stepos.ability.net.biz.model.DeviceAppRequest;
import com.stepos.mcp.sdk.java.ServerExt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "com.stepos.ability.manager.watcher.AbilityInstallerWatcher$refreshAndUpload$1", f = "AbilityInstallerWatcher.kt", l = {176, 178, 181, 194, 199, 211, 216, 224}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class AbilityInstallerWatcher$refreshAndUpload$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3166a;
    public int b;
    public List c;
    public ServerExt d;
    public List e;
    public EmptyList f;
    public DeviceAppRequest g;
    public Context h;
    public Iterator i;

    /* renamed from: j, reason: collision with root package name */
    public int f3167j;
    public final /* synthetic */ b k;
    public final /* synthetic */ Context l;
    public final /* synthetic */ String m;
    public final /* synthetic */ boolean n;
    public final /* synthetic */ AppInfoUtils.AppInfo o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilityInstallerWatcher$refreshAndUpload$1(b bVar, Context context, String str, boolean z10, AppInfoUtils.AppInfo appInfo, H7.c cVar) {
        super(2, cVar);
        this.k = bVar;
        this.l = context;
        this.m = str;
        this.n = z10;
        this.o = appInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new AbilityInstallerWatcher$refreshAndUpload$1(this.k, this.l, this.m, this.n, this.o, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((AbilityInstallerWatcher$refreshAndUpload$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:99:0x0298, code lost:
    
        if (r3 == r10) goto L118;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0253 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x017a A[Catch: Exception -> 0x01a8, TryCatch #0 {Exception -> 0x01a8, blocks: (B:57:0x014d, B:59:0x016b, B:61:0x0171, B:63:0x017a, B:68:0x01ac, B:73:0x01b7, B:53:0x0129, B:46:0x0116), top: B:119:0x0116 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01d5 A[Catch: Exception -> 0x0212, PHI: r0 r2 r13 r15
      0x01d5: PHI (r0v23 com.stepos.ability.manager.watcher.b) = (r0v10 com.stepos.ability.manager.watcher.b), (r0v1 com.stepos.ability.manager.watcher.b) binds: [B:76:0x01d1, B:19:0x006d] A[DONT_GENERATE, DONT_INLINE]
      0x01d5: PHI (r2v17 java.lang.Object) = (r2v14 java.lang.Object), (r2v24 java.lang.Object) binds: [B:76:0x01d1, B:19:0x006d] A[DONT_GENERATE, DONT_INLINE]
      0x01d5: PHI (r13v13 int) = (r13v31 int), (r13v14 int) binds: [B:76:0x01d1, B:19:0x006d] A[DONT_GENERATE, DONT_INLINE]
      0x01d5: PHI (r15v17 java.lang.String) = (r15v13 java.lang.String), (r15v18 java.lang.String) binds: [B:76:0x01d1, B:19:0x006d] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {Exception -> 0x0212, blocks: (B:101:0x029b, B:103:0x02a0, B:105:0x02bb, B:110:0x02c8, B:114:0x02d7, B:87:0x0223, B:89:0x0229, B:92:0x0253, B:94:0x025b, B:96:0x0273, B:98:0x027f, B:78:0x01d5, B:80:0x01e1, B:86:0x0215, B:75:0x01cd), top: B:122:0x01cd }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01e1 A[Catch: Exception -> 0x0212, TryCatch #2 {Exception -> 0x0212, blocks: (B:101:0x029b, B:103:0x02a0, B:105:0x02bb, B:110:0x02c8, B:114:0x02d7, B:87:0x0223, B:89:0x0229, B:92:0x0253, B:94:0x025b, B:96:0x0273, B:98:0x027f, B:78:0x01d5, B:80:0x01e1, B:86:0x0215, B:75:0x01cd), top: B:122:0x01cd }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0215 A[Catch: Exception -> 0x0212, TryCatch #2 {Exception -> 0x0212, blocks: (B:101:0x029b, B:103:0x02a0, B:105:0x02bb, B:110:0x02c8, B:114:0x02d7, B:87:0x0223, B:89:0x0229, B:92:0x0253, B:94:0x025b, B:96:0x0273, B:98:0x027f, B:78:0x01d5, B:80:0x01e1, B:86:0x0215, B:75:0x01cd), top: B:122:0x01cd }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0229 A[Catch: Exception -> 0x0212, TryCatch #2 {Exception -> 0x0212, blocks: (B:101:0x029b, B:103:0x02a0, B:105:0x02bb, B:110:0x02c8, B:114:0x02d7, B:87:0x0223, B:89:0x0229, B:92:0x0253, B:94:0x025b, B:96:0x0273, B:98:0x027f, B:78:0x01d5, B:80:0x01e1, B:86:0x0215, B:75:0x01cd), top: B:122:0x01cd }] */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v27 */
    /* JADX WARN: Type inference failed for: r13v28 */
    /* JADX WARN: Type inference failed for: r13v29 */
    /* JADX WARN: Type inference failed for: r13v30 */
    /* JADX WARN: Type inference failed for: r13v7 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 772
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.watcher.AbilityInstallerWatcher$refreshAndUpload$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
