package com.stepos.agentframework.chatui.appui;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u0004\b\u0001\u0010\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0001H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH&¢\u0006\u0004\b\u000f\u0010\u0006J\u001d\u0010\u0012\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0006J\u0015\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001b2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010$\u001a\u0004\u0018\u00018\u00002\b\u0010#\u001a\u0004\u0018\u00018\u00008\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/stepos/agentframework/chatui/appui/a;", "Landroid/view/View;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "D", "", "<init>", "()V", "data", "LY8/t;", "f", "(Ljava/lang/Object;)V", "Landroid/content/Context;", "context", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)Landroid/view/View;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lcom/stepos/agentframework/chatui/appui/i;", "host", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Lcom/stepos/agentframework/chatui/appui/i;)Landroid/view/View;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "", "json", "e", "(Ljava/lang/String;)V", "", "index", "Ljava/lang/Class;", Const.INTENT_KEY_UMID, "(I)Ljava/lang/Class;", "Lcom/stepos/agentframework/chatui/appui/i;", "getHost", "()Lcom/stepos/agentframework/chatui/appui/i;", "setHost", "(Lcom/stepos/agentframework/chatui/appui/i;)V", UxipConstants.f30680s, "appUIView", "Landroid/view/View;", "c", "()Landroid/view/View;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class a<V extends View, D> {
    private V appUIView;
    private i host;

    public final V a(Context context, i host) {
        p.i(context, "context");
        p.i(host, "host");
        this.host = host;
        V v10 = (V) b(context);
        this.appUIView = v10;
        return v10;
    }

    public abstract V b(Context context);

    public final V c() {
        return this.appUIView;
    }

    public final Class<?> d(int index) {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType)) {
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        if (index >= 0 && index < actualTypeArguments.length) {
            Type type = actualTypeArguments[index];
            if (type instanceof Class) {
                return (Class) type;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(String json) throws JsonSyntaxException {
        p.i(json, "json");
        Class<?> clsD = d(1);
        if (clsD == null) {
            return;
        }
        Object objFromJson = new Gson().fromJson(json, (Class<Object>) clsD);
        if (clsD.isInstance(objFromJson)) {
            f(objFromJson);
            return;
        }
        throw new IllegalArgumentException("JSON 类型不匹配，期望：" + clsD.getName() + "，实际：" + (objFromJson != null ? objFromJson.getClass().getName() : null));
    }

    public abstract void f(D data);

    public abstract void g();

    public final void h() {
        g();
        this.host = null;
        this.appUIView = null;
    }
}
