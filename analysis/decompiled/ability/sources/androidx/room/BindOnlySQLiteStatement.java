package androidx.room;

import androidx.annotation.IntRange;
import androidx.compose.foundation.text.selection.SingleSelectionLayout;
import androidx.sqlite.SQLiteStatement;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\u0005\b\u0002\u0018\u0000 ;2\u00020\u0001:\u0001;B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0012J\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u001dH\u0016¢\u0006\u0004\b \u0010\u001fJ\"\u0010\"\u001a\u00020\u001d2\b\b\u0001\u0010\u0006\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0007H\u0096\u0001¢\u0006\u0004\b\"\u0010#J\"\u0010$\u001a\u00020\u001d2\b\b\u0001\u0010\u0006\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b$\u0010%J\"\u0010'\u001a\u00020\u001d2\b\b\u0001\u0010\u0006\u001a\u00020\u00052\u0006\u0010!\u001a\u00020&H\u0096\u0001¢\u0006\u0004\b'\u0010(J\"\u0010)\u001a\u00020\u001d2\b\b\u0001\u0010\u0006\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b)\u0010*J\"\u0010+\u001a\u00020\u001d2\b\b\u0001\u0010\u0006\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b+\u0010,J\"\u0010-\u001a\u00020\u001d2\b\b\u0001\u0010\u0006\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b-\u0010.J\"\u0010/\u001a\u00020\u001d2\b\b\u0001\u0010\u0006\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b/\u00100J\u001a\u00101\u001a\u00020\u001d2\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b1\u00102J\u001a\u00103\u001a\u00020&2\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b3\u00104J\u001a\u00105\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b5\u0010\u001aJ\u001a\u00106\u001a\u00020\u00132\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b6\u0010\u0015J\u0016\u00108\u001a\b\u0012\u0004\u0012\u00020\u001007H\u0096\u0001¢\u0006\u0004\b8\u00109J\u0010\u0010:\u001a\u00020\u001dH\u0096\u0001¢\u0006\u0004\b:\u0010\u001f¨\u0006<"}, d2 = {"Landroidx/room/BindOnlySQLiteStatement;", "Landroidx/sqlite/SQLiteStatement;", "delegate", AppAgent.CONSTRUCT, "(Landroidx/sqlite/SQLiteStatement;)V", "", "index", "", "getBlob", "(I)[B", "", "getDouble", "(I)D", "", "getLong", "(I)J", "", "getText", "(I)Ljava/lang/String;", "", "isNull", "(I)Z", "getColumnCount", "()I", "getColumnName", "getColumnType", "(I)I", "step", "()Z", "LC7/r;", "reset", "()V", "close", "value", "bindBlob", "(I[B)V", "bindDouble", "(ID)V", "", "bindFloat", "(IF)V", "bindLong", "(IJ)V", "bindInt", "(II)V", "bindBoolean", "(IZ)V", "bindText", "(ILjava/lang/String;)V", "bindNull", "(I)V", "getFloat", "(I)F", "getInt", "getBoolean", "", "getColumnNames", "()Ljava/util/List;", "clearBindings", "Companion", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class BindOnlySQLiteStatement implements SQLiteStatement {
    private static final String ONLY_BIND_CALLS_ALLOWED_ERROR = "Only bind*() calls are allowed on the RoomRawQuery received statement.";
    private final /* synthetic */ SQLiteStatement $$delegate_0;

    public BindOnlySQLiteStatement(SQLiteStatement delegate) {
        k.f(delegate, "delegate");
        this.$$delegate_0 = delegate;
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindBlob */
    public void mo7168bindBlob(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index, byte[] value) {
        k.f(value, "value");
        this.$$delegate_0.mo7168bindBlob(index, value);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void bindBoolean(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index, boolean value) {
        this.$$delegate_0.bindBoolean(index, value);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindDouble */
    public void mo7169bindDouble(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index, double value) {
        this.$$delegate_0.mo7169bindDouble(index, value);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void bindFloat(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index, float value) {
        this.$$delegate_0.bindFloat(index, value);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void bindInt(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index, int value) {
        this.$$delegate_0.bindInt(index, value);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindLong */
    public void mo7170bindLong(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index, long value) {
        this.$$delegate_0.mo7170bindLong(index, value);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindNull */
    public void mo7171bindNull(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index) {
        this.$$delegate_0.mo7171bindNull(index);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindText */
    public void mo7172bindText(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index, String value) {
        k.f(value, "value");
        this.$$delegate_0.mo7172bindText(index, value);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: clearBindings */
    public void mo7173clearBindings() {
        this.$$delegate_0.mo7173clearBindings();
    }

    @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public byte[] getBlob(int index) {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean getBoolean(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
        return this.$$delegate_0.getBoolean(index);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getColumnCount() {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public String getColumnName(int index) {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public List<String> getColumnNames() {
        return this.$$delegate_0.getColumnNames();
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getColumnType(int index) {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public double getDouble(int index) {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public float getFloat(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
        return this.$$delegate_0.getFloat(index);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getInt(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
        return this.$$delegate_0.getInt(index);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public long getLong(int index) {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public String getText(int index) {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean isNull(int index) {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void reset() {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean step() {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }
}
