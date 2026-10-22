package bu6;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.locallife.host.search.Word;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes21.dex */
public interface a extends ns6.a {
    Map X();

    @Override // ns6.a
    List<String> a();

    void m(FragmentActivity r100, b r101, Function2<? super List<Word>, ? super String, Unit> r102, Function1<? super Exception, Unit> r103);

    void q(Context r100, c r101, Function1 r102);
}
