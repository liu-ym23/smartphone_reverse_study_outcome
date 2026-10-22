package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.List;
import q7.C1816n;
import q7.C1823v;

/* loaded from: classes2.dex */
public final class ListHooksResponse$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ ListHooksResponse$Builder(int i) {
        this();
    }

    public ListHooksResponse$Builder addAllHooks(Iterable<? extends C1816n> iterable) {
        copyOnWrite();
        C1823v.D((C1823v) this.instance, iterable);
        return this;
    }

    public ListHooksResponse$Builder addHooks(C1816n c1816n) {
        copyOnWrite();
        C1823v.F((C1823v) this.instance, c1816n);
        return this;
    }

    public ListHooksResponse$Builder clearError() {
        copyOnWrite();
        C1823v.G((C1823v) this.instance);
        return this;
    }

    public ListHooksResponse$Builder clearHooks() {
        copyOnWrite();
        C1823v.H((C1823v) this.instance);
        return this;
    }

    public String getError() {
        return ((C1823v) this.instance).O();
    }

    public ByteString getErrorBytes() {
        return ((C1823v) this.instance).P();
    }

    public C1816n getHooks(int i) {
        return ((C1823v) this.instance).Q(i);
    }

    public int getHooksCount() {
        return ((C1823v) this.instance).R();
    }

    public List<C1816n> getHooksList() {
        return Collections.unmodifiableList(((C1823v) this.instance).S());
    }

    public ListHooksResponse$Builder removeHooks(int i) {
        copyOnWrite();
        C1823v.I((C1823v) this.instance, i);
        return this;
    }

    public ListHooksResponse$Builder setError(String str) {
        copyOnWrite();
        C1823v.J((C1823v) this.instance, str);
        return this;
    }

    public ListHooksResponse$Builder setErrorBytes(ByteString byteString) {
        copyOnWrite();
        C1823v.K((C1823v) this.instance, byteString);
        return this;
    }

    public ListHooksResponse$Builder setHooks(int i, C1816n c1816n) {
        copyOnWrite();
        C1823v.L((C1823v) this.instance, i, c1816n);
        return this;
    }

    private ListHooksResponse$Builder() {
        super(C1823v.DEFAULT_INSTANCE);
    }

    public ListHooksResponse$Builder addHooks(int i, C1816n c1816n) {
        copyOnWrite();
        C1823v.E((C1823v) this.instance, i, c1816n);
        return this;
    }

    public ListHooksResponse$Builder setHooks(int i, HookDefinition$Builder hookDefinition$Builder) {
        copyOnWrite();
        C1823v.L((C1823v) this.instance, i, (C1816n) hookDefinition$Builder.k());
        return this;
    }

    public ListHooksResponse$Builder addHooks(HookDefinition$Builder hookDefinition$Builder) {
        copyOnWrite();
        C1823v.F((C1823v) this.instance, (C1816n) hookDefinition$Builder.k());
        return this;
    }

    public ListHooksResponse$Builder addHooks(int i, HookDefinition$Builder hookDefinition$Builder) {
        copyOnWrite();
        C1823v.E((C1823v) this.instance, i, (C1816n) hookDefinition$Builder.k());
        return this;
    }
}
