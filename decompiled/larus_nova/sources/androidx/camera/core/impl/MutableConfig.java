package androidx.camera.core.impl;

/* JADX INFO: loaded from: classes2.dex */
public interface MutableConfig extends Config {
    <ValueT> void insertOption(Config.Option<ValueT> r100, Config.OptionPriority r101, ValueT r102);

    <ValueT> void insertOption(Config.Option<ValueT> r100, ValueT r101);

    <ValueT> ValueT removeOption(Config.Option<ValueT> r100);
}
