package boc;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.ActionMode;
import android.view.Menu;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.suite.lark.emm.impl.clipboard.SCClipboardScene;

/* JADX INFO: loaded from: classes40.dex */
public interface b {
    boolean L0();

    void M0(ClipData r100, Token r101) throws SensitiveAPIException;

    void N0(Menu r100);

    void O0(SCClipboardScene r100);

    ActionMode.Callback P0(ActionMode.Callback r100, Boolean r101);

    void Q0(SCClipboardScene r100);

    ActionMode.Callback R0(ActionMode.Callback r100);

    void S0(Menu r100);

    ClipData T0(Token r100) throws SensitiveAPIException;

    void d(ClipboardManager.OnPrimaryClipChangedListener r100);

    void e(ClipboardManager.OnPrimaryClipChangedListener r100);

    boolean f();
}
