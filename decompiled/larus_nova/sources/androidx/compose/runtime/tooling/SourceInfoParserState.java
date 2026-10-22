package androidx.compose.runtime.tooling;

import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0003J\u000e\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003J\u0006\u0010\u001a\u001a\u00020\u0003J\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0003J\u0010\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\tJ\u0006\u0010\u001e\u001a\u00020\u0011J\u0006\u0010\u001f\u001a\u00020\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006 "}, d2 = {"Landroidx/compose/runtime/tooling/SourceInfoParserState;", "", "data", "", "<init>", "(Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", RXScreenCaptureService.KEY_INDEX, "", "getI", "()I", "setI", "(I)V", "expect", "", "char", "", "throwParseError", "", "message", "matches", "", "takeIntUntil", "separator", "takeUntil", "takeUntilEnd", "skipUntil", "advance", "count", "current", "atEnd", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class SourceInfoParserState {
    private final String data;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f15157i;

    public final boolean atEnd() {
        if (this.f15157i < this.data.length()) goto L5;
        return true;
    L5:
        return false;
    }

    public final char current() {
        return this.data.charAt(this.f15157i);
    }

    public final String takeUntilEnd() {
        String r100 = this.data;
        return r100.substring(this.f15157i, r100.length());
    }

    public final String getData() {
        return this.data;
    }

    public final int getI() {
        return this.f15157i;
    }

    public SourceInfoParserState(String r100) {
        this.data = r100;
    }

    public final void advance(int r100) {
        this.f15157i += r100;
    }

    public final void expect(char r100) {
        if (matches(r100) == false) goto L5;
        return;
    L5:
        throwParseError("expected " + r100);
        throw new KotlinNothingValueException();
    }

    public final boolean matches(char r100) {
        if (this.f15157i < this.data.length()) goto L5;
    L7:
        return false;
    L5:
        if (this.data.charAt(this.f15157i) != r100) goto L7;
        return true;
    }

    public final void setI(int r100) {
        this.f15157i = r100;
    }

    public final void skipUntil(String r100) {
    L3:
        if (this.f15157i >= this.data.length()) goto L7;
        if (StringsKt.contains$default(r100, this.data.charAt(this.f15157i), false, 2, null) == true) goto L10;
        this.f15157i++;
        goto L3
    L10:
        return;
    }

    public final int takeIntUntil(String r100) {
        Integer r101 = StringsKt.toIntOrNull(takeUntil(r100));
        if (r101 != null) goto L5;
        throwParseError("expected int");
        throw new KotlinNothingValueException();
    L5:
        return r101.intValue();
    }

    public final String takeUntil(String r100) {
        int r101 = this.f15157i;
        skipUntil(r100);
        int r102 = this.f15157i;
        if (r102 > r101) goto L7;
        return "";
    L7:
        return this.data.substring(r101, r102);
    }

    public final Void throwParseError(String r100) {
        int r101 = Math.min(this.f15157i, this.data.length());
        throw new ParseException("Error while parsing source information: " + r100 + " at " + this.data.substring(0, r101) + '|' + this.data.substring(r101));
    }

    public static /* synthetic */ void advance$default(SourceInfoParserState r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = 1;
    L5:
        r100.advance(r101);
    }
}
