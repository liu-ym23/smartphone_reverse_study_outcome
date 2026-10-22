package xc;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public zc.a f13776a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: xc.a$a, reason: collision with other inner class name */
    public static class C0170a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f13777a;

        static {
            a aVar = new a();
            aVar.f13776a = null;
            try {
                zc.a aVar2 = new zc.a();
                aVar.f13776a = aVar2;
                aVar2.a(new BufferedInputStream(c.class.getResourceAsStream("/pinyindb/unicode_to_hanyu_pinyin.txt")));
                aVar.f13776a.b(new BufferedInputStream(c.class.getResourceAsStream("/pinyindb/multi_pinyin.txt")));
                aVar.f13776a.getClass();
            } catch (FileNotFoundException e10) {
                e10.printStackTrace();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
            f13777a = aVar;
        }
    }
}
