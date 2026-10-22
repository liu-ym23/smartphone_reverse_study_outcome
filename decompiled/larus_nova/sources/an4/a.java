package an4;

import com.bytedance.ee.bear.document.model.toolbar.ToolbarV2;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes15.dex */
@UserScope
public interface a extends IOfficeSDKProtocol {
    d getGlobalDecoration();

    Set<e> getItemFactorySet();

    Function1<String, Unit> getOnToolbarItemClickCallBack();

    Function1<ToolbarV2, Unit> getOnUpdateToolBarCallBack();
}
