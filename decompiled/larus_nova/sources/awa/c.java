package awa;

import com.larksuite.framework.callback.IGetDataCallback;
import io.reactivex.Scheduler;

/* JADX INFO: loaded from: classes34.dex */
public interface c {
    void Bd(String r100, Class r101, IGetDataCallback<Double> r102);

    void C9(String r100, Class r101, IGetDataCallback<String> r102);

    void D7(String r100, Class r101, Scheduler r102, Scheduler r103, IGetDataCallback<Double> r104);

    <T> void M5(String r100, Class<T> r101, IGetDataCallback<T> r102);

    int T1(String r100, Class<?> r101);

    String V5(String r100, Class<?> r101);

    long b4(String r100, Class<?> r101);

    void f7(String r100, Class r101, Scheduler r102, Scheduler r103, IGetDataCallback<Integer> r104);

    void k9(String r100, Class r101, IGetDataCallback<Integer> r102);

    void m2(String r100, Class r101, Scheduler r102, Scheduler r103, IGetDataCallback<Boolean> r104);

    double m6(String r100, Class<?> r101);

    void p5(String r100, Class r101, Scheduler r102, Scheduler r103, IGetDataCallback<String> r104);

    String q0(String r100, String r101, boolean r102);

    boolean s3(String r100, Class<?> r101);

    void sc(String r100, Class r101, IGetDataCallback<Boolean> r102);

    <T> void x3(String r100, Class<T> r101, Scheduler r102, Scheduler r103, IGetDataCallback<T> r104);

    <T> T y0(String r100, Class<T> r101);
}
