package com.bytedance.android.live.browser.schema.core.strategy;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class BlockStateStrategy extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f64209c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f64210b;

    public static final class a {
    }

    public static final class b implements c.b {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r1v3, types: [java.util.ArrayList] */
        @Override // com.bytedance.android.live.browser.schema.core.strategy.c.b
        public final c a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "json");
            JSONArray r101 = r100.optJSONArray("blockKeys");
            if (r101 == null) goto L7;
            ?? r102 = new ArrayList();
            int r103 = r101.length();
            int r104 = 0;
        L5:
            if (r104 >= r103) goto L9;
            r102.add(JSONArrayProtectorUtils.getString(r101, r104));
            r104 = r104 + 1;
        L9:
            return new BlockStateStrategy(r102);
        L7:
            r102 = CollectionsKt.emptyList();
            goto L9
        }
    }

    static {
    }

    public BlockStateStrategy(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "keys");
        super(3);
        this.f64210b = r100;
    }

    @Override // com.bytedance.android.live.browser.schema.core.strategy.c
    public final boolean a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "currentState");
        if ((!this.f64210b.isEmpty()) == false) goto L17;
        final JSONObject r101 = new JSONObject();
        r100.put("block_key", r101);
        Iterator r102 = SequencesKt.map(CollectionsKt.asSequence(this.f64210b), new BlockStateStrategy$match$2(this, r101)).iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();
        if (((Boolean) r103).booleanValue() == false) goto L6;
    L11:
        Boolean r104 = (Boolean) r103;
        if (r104 != null) goto L21;
        return false;
    L21:
        return r104.booleanValue();
    L10:
        r103 = null;
        goto L11
    L17:
        throw new IllegalStateException("block keys not exists or keys is empty, please check config".toString());
    }
}
