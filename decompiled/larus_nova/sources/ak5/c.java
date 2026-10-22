package ak5;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import java.io.Serializable;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes18.dex */
public final class c<T extends Serializable> implements s<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f4006a;

    public c(Type r100) {
        this.f4006a = r100;
    }

    @Override // ak5.s
    public final T parse(String r100) {
        return (T) JSON.parseObject(r100, this.f4006a, new Feature[0]);
    L5:
        e = move-exception;
        tt5.a.e("DefaultParser", "parseData: found error", e, false);
        return null;
    }
}
