package be8;

import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.chat.component.skill.PcEntryDisplayMode;
import com.larus.im.bean.message.block.QuickReplyBlock;
import com.larus.im.bean.message.block.QuickReplyItem;
import java.util.List;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
public interface a extends m1a.a {
    void C30();

    boolean DA(String r100, QuickReplyBlock r101, String r102, QuickReplyItem r103, int r104);

    void ER();

    void H70();

    PcEntryDisplayMode LF();

    void N10(d r100, boolean r101);

    boolean NV();

    void PR(List<String> r100, Function0<Unit> r101);

    void RV();

    void U40(String r100);

    void UF(f r100, c r101);

    String V7();

    String Ve();

    void WY(b r100);

    Object Xr(Continuation<? super Result<? extends List<b>>> r100);

    void Y20();

    boolean YD();

    c YF();

    MutableLiveData Zo();

    void aB();

    void aH();

    String dC();

    e getSelectedFolder();

    List<b> iH();

    String lo();

    String nF();

    String nn(String r100, List<String> r101);

    boolean oW(String r100);

    void pC();

    boolean qX();

    boolean sY();
}
