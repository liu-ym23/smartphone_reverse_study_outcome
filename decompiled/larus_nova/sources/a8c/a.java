package a8c;

import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.utils.LarkContext;
import com.suite.lark.component.protocol.Biz;
import g7c.j;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f2210a;

    /* JADX INFO: renamed from: a8c.a$a, reason: collision with other inner class name */
    public static final class C0028a {
    }

    static {
    }

    public final boolean a() {
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L6;
        return true;
    L6:
        if (LarkAppContext.access$getInstance$cp().buildConfig().isUsPackage() == false) goto L9;
        return false;
    L9:
        if (DevEnvUtil.isDevelopPackage(LarkContext.getApplication()) == false) goto L18;
        if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == false) goto L14;
        int r100 = c9c.a.f22914a;
        return LarkKVStorage.j(Biz.Meego, false).getBoolean("enable_todo_web", true);
    L14:
        int r101 = c9c.a.f22914a;
        if (LarkKVStorage.j(Biz.Meego, false).getBoolean("enable_todo_web", true) == false) goto L18;
        return true;
    L18:
        return this.f2210a.a("lark.biz.todo.flutter.enable", false);
    }

    public a() {
        this.f2210a = TodoDependencyHolder.a().featureGatingDependency();
    }
}
