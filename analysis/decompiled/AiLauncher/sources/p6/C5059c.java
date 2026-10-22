package p6;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.tencent.mmkv.MMKV;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000f¨\u0006\u0010"}, d2 = {"Lp6/c;", "Lp6/b;", "Lcom/tencent/mmkv/MMKV;", "mmkv", "<init>", "(Lcom/tencent/mmkv/MMKV;)V", "", "key", UxipConstants.f30680s, "", "putString", "(Ljava/lang/String;Ljava/lang/String;)Z", "default", "getString", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lcom/tencent/mmkv/MMKV;", "storage_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: p6.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5059c implements InterfaceC5058b {
    private final MMKV mmkv;

    public C5059c(MMKV mmkv) {
        p.i(mmkv, "mmkv");
        this.mmkv = mmkv;
    }

    @Override // p6.InterfaceC5058b
    public String getString(String key, String str) {
        p.i(key, "key");
        p.i(str, "default");
        String strH = this.mmkv.h(key, str);
        return strH == null ? str : strH;
    }

    @Override // p6.InterfaceC5058b
    public boolean putString(String key, String value) {
        p.i(key, "key");
        p.i(value, "value");
        return this.mmkv.r(key, value);
    }
}
