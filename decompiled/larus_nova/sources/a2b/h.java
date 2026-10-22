package a2b;

import com.ss.android.lark.chat.api.service.PrivateDescriptionSource;
import com.ss.android.lark.chat.api.service.Strategy;
import com.ss.android.lark.chat.entity.chatter.UserPrivateDescription;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes35.dex */
public interface h {
    Object S0(List<String> r100, PrivateDescriptionSource r101, Strategy r102, Continuation<? super Result<? extends Map<String, UserPrivateDescription>>> r103);
}
