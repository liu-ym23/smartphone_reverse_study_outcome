package com.alibaba.gaiax.data;

import android.content.Context;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.api.GXRegisterCenterApi;
import com.alibaba.gaiax.template.GXTemplate;
import com.alibaba.gaiax.template.GXTemplateInfo;
import com.alibaba.gaiax.template.GXTemplateItem;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/alibaba/gaiax/data/GXDataImpl;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "templateInfoSource", "Lcom/alibaba/gaiax/data/GXDataImpl$GXTemplateInfoSource;", "getTemplateInfoSource", "()Lcom/alibaba/gaiax/data/GXDataImpl$GXTemplateInfoSource;", "templateInfoSource$delegate", "Lkotlin/Lazy;", "templateSource", "Lcom/alibaba/gaiax/data/GXDataImpl$GXTemplateSource;", "getTemplateSource", "()Lcom/alibaba/gaiax/data/GXDataImpl$GXTemplateSource;", "templateSource$delegate", "getTemplateInfo", "Lcom/alibaba/gaiax/template/GXTemplateInfo;", "templateItem", "Lcom/alibaba/gaiax/template/GXTemplateItem;", "GXTemplateInfoSource", "GXTemplateSource", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXDataImpl {
    private final Context context;
    private final Lazy templateInfoSource$delegate;
    private final Lazy templateSource$delegate;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/alibaba/gaiax/data/GXDataImpl$GXTemplateInfoSource;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionTemplateInfoSource;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "dataSource", "Ljava/util/PriorityQueue;", "Lcom/alibaba/gaiax/data/GXDataImpl$GXTemplateInfoSource$Value;", "dataSourceSorted", "", "getTemplateInfo", "Lcom/alibaba/gaiax/template/GXTemplateInfo;", "gxTemplateItem", "Lcom/alibaba/gaiax/template/GXTemplateItem;", "registerByPriority", "", "source", "priority", "", BasicTestActionHandler.TEST_ACTION_RESET, "Value", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class GXTemplateInfoSource implements GXRegisterCenter.GXIExtensionTemplateInfoSource {
        private final Context context;
        private final PriorityQueue<Value> dataSource;
        private final List<Value> dataSourceSorted;

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/alibaba/gaiax/data/GXDataImpl$GXTemplateInfoSource$Value;", "", "priority", "", "source", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionTemplateInfoSource;", "(ILcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionTemplateInfoSource;)V", "getPriority", "()I", "getSource", "()Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionTemplateInfoSource;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Value {
            private final int priority;
            private final GXRegisterCenter.GXIExtensionTemplateInfoSource source;

            public static /* synthetic */ Value copy$default(Value r100, int r101, GXRegisterCenter.GXIExtensionTemplateInfoSource r102, int r103, Object r104) {
                if ((r103 & 1) == 0) goto L6;
                r101 = r100.priority;
            L6:
                if ((r103 & 2) == 0) goto L9;
                r102 = r100.source;
            L9:
                return r100.copy(r101, r102);
            }

            public final int component1() {
                return this.priority;
            }

            public final GXRegisterCenter.GXIExtensionTemplateInfoSource component2() {
                return this.source;
            }

            public final Value copy(int r100, GXRegisterCenter.GXIExtensionTemplateInfoSource r101) {
                Intrinsics.checkNotNullParameter(r101, "source");
                return new Value(r100, r101);
            }

            public String toString() {
                return "Value(priority=" + this.priority + ", source=" + this.source + ')';
            }

            public final int getPriority() {
                return this.priority;
            }

            public final GXRegisterCenter.GXIExtensionTemplateInfoSource getSource() {
                return this.source;
            }

            public int hashCode() {
                return this.priority;
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if (r100 == null) goto L8;
                Class<?> r101 = r100.getClass();
            L10:
                if (Intrinsics.areEqual(Value.class, r101) == true) goto L12;
                return false;
            L12:
                Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.alibaba.gaiax.data.GXDataImpl.GXTemplateInfoSource.Value");
                if (this.priority == ((Value) r100).priority) goto L15;
                return false;
            L15:
                return true;
            L8:
                r101 = null;
                goto L10
            }

            public Value(int r100, GXRegisterCenter.GXIExtensionTemplateInfoSource r101) {
                Intrinsics.checkNotNullParameter(r101, "source");
                this.priority = r100;
                this.source = r101;
            }
        }

        public static /* synthetic */ int a(Function2 r100, Object r101, Object r102) {
            return dataSource$lambda$0(r100, r101, r102);
        }

        public static /* synthetic */ int b(Function2 r100, Object r101, Object r102) {
            return registerByPriority$lambda$4(r100, r101, r102);
        }

        public final void reset() {
            this.dataSource.clear();
            this.dataSourceSorted.clear();
        }

        public final Context getContext() {
            return this.context;
        }

        public GXTemplateInfoSource(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.context = r100;
            final GXDataImpl$GXTemplateInfoSource$dataSource$1 r101 = GXDataImpl$GXTemplateInfoSource$dataSource$1.INSTANCE;
            this.dataSource = new PriorityQueue(11, new b(r101));
            this.dataSourceSorted = new ArrayList();
        }

        @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionTemplateInfoSource
        public GXTemplateInfo getTemplateInfo(GXTemplateItem r100) {
            Intrinsics.checkNotNullParameter(r100, "gxTemplateItem");
            Iterator<T> r101 = this.dataSourceSorted.iterator();
        L4:
            if (r101.hasNext() == false) goto L9;
            GXTemplateInfo r102 = ((Value) r101.next()).getSource().getTemplateInfo(r100);
            if (r102 == null) goto L4;
            return r102;
        L9:
            throw new IllegalArgumentException("Not found target gxTemplateInfo, templateItem = " + r100);
        }

        public final void registerByPriority(GXRegisterCenter.GXIExtensionTemplateInfoSource r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "source");
            Iterator<T> r102 = this.dataSource.iterator();
            Value r103 = null;
        L4:
            if (r102.hasNext() == false) goto L8;
            Value r104 = (Value) r102.next();
            if (r104.getPriority() != r101) goto L4;
            r103 = r104;
            goto L4
        L8:
            this.dataSource.remove(r103);
            this.dataSource.add(new Value(r101, r100));
            final GXDataImpl$GXTemplateInfoSource$registerByPriority$dataSource$1 r105 = GXDataImpl$GXTemplateInfoSource$registerByPriority$dataSource$1.INSTANCE;
            PriorityQueue r106 = new PriorityQueue(11, new a(r105));
            r106.addAll(this.dataSource);
            this.dataSourceSorted.clear();
        L10:
            if ((!r106.isEmpty()) == false) goto L12;
            this.dataSourceSorted.add((Value) r106.poll());
            goto L10
        }

        private static final int dataSource$lambda$0(Function2 r100, Object r101, Object r102) {
            Intrinsics.checkNotNullParameter(r100, "$tmp0");
            return ((Number) r100.invoke(r101, r102)).intValue();
        }

        private static final int registerByPriority$lambda$4(Function2 r100, Object r101, Object r102) {
            Intrinsics.checkNotNullParameter(r100, "$tmp0");
            return ((Number) r100.invoke(r101, r102)).intValue();
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/alibaba/gaiax/data/GXDataImpl$GXTemplateSource;", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionTemplateSource;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "dataSource", "Ljava/util/PriorityQueue;", "Lcom/alibaba/gaiax/data/GXDataImpl$GXTemplateSource$Value;", "dataSourceSorted", "", "getTemplate", "Lcom/alibaba/gaiax/template/GXTemplate;", "gxTemplateItem", "Lcom/alibaba/gaiax/template/GXTemplateItem;", "registerByPriority", "", "source", "priority", "", BasicTestActionHandler.TEST_ACTION_RESET, "Value", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class GXTemplateSource implements GXRegisterCenterApi.GXIExtensionTemplateSource {
        private final Context context;
        private final PriorityQueue<Value> dataSource;
        private final List<Value> dataSourceSorted;

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/alibaba/gaiax/data/GXDataImpl$GXTemplateSource$Value;", "", "priority", "", "source", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionTemplateSource;", "(ILcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionTemplateSource;)V", "getPriority", "()I", "getSource", "()Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionTemplateSource;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Value {
            private final int priority;
            private final GXRegisterCenterApi.GXIExtensionTemplateSource source;

            public static /* synthetic */ Value copy$default(Value r100, int r101, GXRegisterCenterApi.GXIExtensionTemplateSource r102, int r103, Object r104) {
                if ((r103 & 1) == 0) goto L6;
                r101 = r100.priority;
            L6:
                if ((r103 & 2) == 0) goto L9;
                r102 = r100.source;
            L9:
                return r100.copy(r101, r102);
            }

            public final int component1() {
                return this.priority;
            }

            public final GXRegisterCenterApi.GXIExtensionTemplateSource component2() {
                return this.source;
            }

            public final Value copy(int r100, GXRegisterCenterApi.GXIExtensionTemplateSource r101) {
                Intrinsics.checkNotNullParameter(r101, "source");
                return new Value(r100, r101);
            }

            public String toString() {
                return "Value(priority=" + this.priority + ", source=" + this.source + ')';
            }

            public final int getPriority() {
                return this.priority;
            }

            public final GXRegisterCenterApi.GXIExtensionTemplateSource getSource() {
                return this.source;
            }

            public int hashCode() {
                return this.priority;
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if (r100 == null) goto L8;
                Class<?> r101 = r100.getClass();
            L10:
                if (Intrinsics.areEqual(Value.class, r101) == true) goto L12;
                return false;
            L12:
                Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.alibaba.gaiax.data.GXDataImpl.GXTemplateSource.Value");
                if (this.priority == ((Value) r100).priority) goto L15;
                return false;
            L15:
                return true;
            L8:
                r101 = null;
                goto L10
            }

            public Value(int r100, GXRegisterCenterApi.GXIExtensionTemplateSource r101) {
                Intrinsics.checkNotNullParameter(r101, "source");
                this.priority = r100;
                this.source = r101;
            }
        }

        public static /* synthetic */ int a(Function2 r100, Object r101, Object r102) {
            return registerByPriority$lambda$4(r100, r101, r102);
        }

        public static /* synthetic */ int b(Function2 r100, Object r101, Object r102) {
            return dataSource$lambda$0(r100, r101, r102);
        }

        public final void reset() {
            this.dataSource.clear();
            this.dataSourceSorted.clear();
        }

        public final Context getContext() {
            return this.context;
        }

        public GXTemplateSource(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.context = r100;
            final GXDataImpl$GXTemplateSource$dataSource$1 r101 = GXDataImpl$GXTemplateSource$dataSource$1.INSTANCE;
            this.dataSource = new PriorityQueue(11, new d(r101));
            this.dataSourceSorted = new ArrayList();
        }

        @Override // com.alibaba.gaiax.api.GXRegisterCenterApi.GXIExtensionTemplateSource
        public GXTemplate getTemplate(GXTemplateItem r100) {
            Intrinsics.checkNotNullParameter(r100, "gxTemplateItem");
            Iterator<T> r101 = this.dataSourceSorted.iterator();
        L4:
            if (r101.hasNext() == false) goto L9;
            GXTemplate r102 = ((Value) r101.next()).getSource().getTemplate(r100);
            if (r102 == null) goto L4;
            return r102;
        L9:
            throw new IllegalArgumentException("Not found target gxTemplate, templateItem = " + r100);
        }

        public final void registerByPriority(GXRegisterCenterApi.GXIExtensionTemplateSource r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "source");
            Iterator<T> r102 = this.dataSource.iterator();
            Value r103 = null;
        L4:
            if (r102.hasNext() == false) goto L8;
            Value r104 = (Value) r102.next();
            if (r104.getPriority() != r101) goto L4;
            r103 = r104;
            goto L4
        L8:
            this.dataSource.remove(r103);
            this.dataSource.add(new Value(r101, r100));
            final GXDataImpl$GXTemplateSource$registerByPriority$dataSource$1 r105 = GXDataImpl$GXTemplateSource$registerByPriority$dataSource$1.INSTANCE;
            PriorityQueue r106 = new PriorityQueue(11, new c(r105));
            r106.addAll(this.dataSource);
            this.dataSourceSorted.clear();
        L10:
            if ((!r106.isEmpty()) == false) goto L12;
            this.dataSourceSorted.add((Value) r106.poll());
            goto L10
        }

        private static final int dataSource$lambda$0(Function2 r100, Object r101, Object r102) {
            Intrinsics.checkNotNullParameter(r100, "$tmp0");
            return ((Number) r100.invoke(r101, r102)).intValue();
        }

        private static final int registerByPriority$lambda$4(Function2 r100, Object r101, Object r102) {
            Intrinsics.checkNotNullParameter(r100, "$tmp0");
            return ((Number) r100.invoke(r101, r102)).intValue();
        }
    }

    public final GXTemplateInfoSource getTemplateInfoSource() {
        return (GXTemplateInfoSource) this.templateInfoSource$delegate.getValue();
    }

    public final GXTemplateSource getTemplateSource() {
        return (GXTemplateSource) this.templateSource$delegate.getValue();
    }

    public final Context getContext() {
        return this.context;
    }

    public GXDataImpl(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r100;
        this.templateInfoSource$delegate = LazyKt.lazy(new GXDataImpl$templateInfoSource$2(this));
        this.templateSource$delegate = LazyKt.lazy(new GXDataImpl$templateSource$2(this));
    }

    public final GXTemplateInfo getTemplateInfo(GXTemplateItem r100) {
        Intrinsics.checkNotNullParameter(r100, "templateItem");
        GXRegisterCenterApi.GXIExtensionBizMap r101 = GXRegisterCenter.Companion.getInstance().getExtensionBizMap$GaiaX();
        if (r101 == null) goto L6;
        r101.convert(r100);
    L6:
        return getTemplateInfoSource().getTemplateInfo(r100);
    }
}
