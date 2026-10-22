package b8a;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class e extends l {
    public e(HashMap<String, Object> r100) {
        super(r100);
        m.d(r100, "componentUrl");
        m.d(r100, "mode");
        Double r101 = Double.valueOf(-1.0d);
        m.b(r100, "size", r101).doubleValue();
        Boolean r102 = Boolean.FALSE;
        m.a(r100, DocumentType.DOCX_SYNC_BLOCK_NAME, r102).booleanValue();
        m.a(r100, "loadSuccess", r102).booleanValue();
        m.b(r100, "requireStart", r101).doubleValue();
        m.b(r100, "requireEnd", r101).doubleValue();
        m.b(r100, "decodeStart", r101).doubleValue();
        m.b(r100, "decodeEnd", r101).doubleValue();
    }
}
