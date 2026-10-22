package com.bytedance.android.livesdk.user;

import java.util.HashMap;

/* JADX INFO: loaded from: classes11.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f158634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f158635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, String> f158636c;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.user.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC2426a<T extends AbstractC2426a<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f158637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f158638b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public HashMap<String, String> f158639c;

        public AbstractC2426a() {
        }

        public abstract T a();

        public final T b(String r100) {
            this.f158638b = r100;
            return (T) a();
        }

        public final T c(String r100) {
            this.f158637a = r100;
            return (T) a();
        }
    }

    public a(AbstractC2426a r100) {
        this.f158634a = r100.f158637a;
        this.f158635b = r100.f158638b;
        this.f158636c = r100.f158639c;
    }
}
