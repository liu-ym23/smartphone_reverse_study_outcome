package bp4;

import android.text.TextUtils;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.TableMetaModel;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.defaultvaluerule.DefaultValueRule;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements ExtraProcessor, ExtraTypeProvider {

    /* JADX INFO: renamed from: bp4.a$a, reason: collision with other inner class name */
    public class C0333a extends TypeReference<DefaultValueRule> {
        public C0333a() {
        }
    }

    public a() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider
    public final Type getExtraType(Object r100, String r101) {
        if ((r100 instanceof TableMetaModel.FieldBean) == true) goto L5;
        return null;
    L5:
        if (TextUtils.equals(r101, "defaultValueRule") == true) goto L7;
        return null;
    L7:
        return new C0333a().getType();
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ExtraProcessor
    public final void processExtra(Object r100, String r101, Object r102) {
        if ((r100 instanceof TableMetaModel.FieldBean) == true) goto L5;
        return;
    L5:
        if (TextUtils.equals(r101, "defaultValueRule") == true) goto L7;
        return;
    L7:
        if ((r102 instanceof DefaultValueRule) == false) goto L12;
        DefaultValueRule r103 = (DefaultValueRule) r102;
        ((TableMetaModel.FieldBean) r100).fieldDefaultValueRule = r103;
        return;
    }
}
