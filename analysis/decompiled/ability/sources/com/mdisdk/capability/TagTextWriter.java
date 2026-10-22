package com.mdisdk.capability;

import H4.o;
import J7.c;
import androidx.appfunctions.metadata.a;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.m;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.builders.ListBuilder;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;
import o7.s;
import org.java_websocket.WebSocketImpl;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ^\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f24\u0010\u0012\u001a0\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eH\u0086@¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/mdisdk/capability/TagTextWriter;", "", AppAgent.CONSTRUCT, "()V", "", "text", "", "Lcom/mdisdk/capability/TagTextWriter$Part;", "split", "(Ljava/lang/String;)Ljava/util/List;", "", "tagDelayMillis", "Lcom/mdisdk/capability/TagWriteMode;", "tagWriteMode", "Lkotlin/Function5;", "", "", "LH7/c;", "replace", "write", "(Ljava/lang/String;JLcom/mdisdk/capability/TagWriteMode;LS7/q;LH7/c;)Ljava/lang/Object;", "Part", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TagTextWriter {
    public static final TagTextWriter INSTANCE = new TagTextWriter();

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/mdisdk/capability/TagTextWriter$Part;", "", "text", "", "byCodePoint", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Z)V", "getText", "()Ljava/lang/String;", "getByCodePoint", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Part {
        private final boolean byCodePoint;
        private final String text;

        public Part(String text, boolean z10) {
            k.f(text, "text");
            this.text = text;
            this.byCodePoint = z10;
        }

        public static /* synthetic */ Part copy$default(Part part, String str, boolean z10, int i, Object obj) {
            if ((i & 1) != 0) {
                str = part.text;
            }
            if ((i & 2) != 0) {
                z10 = part.byCodePoint;
            }
            return part.copy(str, z10);
        }

        /* renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getByCodePoint() {
            return this.byCodePoint;
        }

        public final Part copy(String text, boolean byCodePoint) {
            k.f(text, "text");
            return new Part(text, byCodePoint);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Part)) {
                return false;
            }
            Part part = (Part) other;
            return k.b(this.text, part.text) && this.byCodePoint == part.byCodePoint;
        }

        public final boolean getByCodePoint() {
            return this.byCodePoint;
        }

        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            return Boolean.hashCode(this.byCodePoint) + (this.text.hashCode() * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Part(text=");
            sb.append(this.text);
            sb.append(", byCodePoint=");
            return a.r(sb, this.byCodePoint, ')');
        }
    }

    @c(c = "com.mdisdk.capability.TagTextWriter", f = "TagTextWriter.kt", l = {36, 42, 44, 45, 46, 47, ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE, s.MESSAGE_POST_FIELD_NUMBER, 63, 73, 74, 77, WebSocketImpl.DEFAULT_PORT}, m = "write")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.mdisdk.capability.TagTextWriter$write$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TagTextWriter.this.write(null, 0L, null, null, this);
        }
    }

    private TagTextWriter() {
    }

    public final List<Part> split(String text) {
        k.f(text, "text");
        ListBuilder listBuilderY = o.y();
        int iCharCount = 0;
        while (true) {
            if (iCharCount >= text.length()) {
                break;
            }
            int iP0 = m.p0(text, '#', iCharCount, 4);
            if (iP0 < 0) {
                String strSubstring = text.substring(iCharCount);
                k.e(strSubstring, "substring(...)");
                listBuilderY.add(new Part(strSubstring, false));
                break;
            }
            if (iP0 > iCharCount) {
                String strSubstring2 = text.substring(iCharCount, iP0);
                k.e(strSubstring2, "substring(...)");
                listBuilderY.add(new Part(strSubstring2, false));
            }
            iCharCount = iP0;
            while (iCharCount < text.length()) {
                int iCodePointAt = text.codePointAt(iCharCount);
                iCharCount += Character.charCount(iCodePointAt);
                if (Character.isWhitespace(iCodePointAt) || Character.isSpaceChar(iCodePointAt)) {
                    break;
                }
            }
            String strSubstring3 = text.substring(iP0, iCharCount);
            k.e(strSubstring3, "substring(...)");
            listBuilderY.add(new Part(strSubstring3, true));
        }
        return o.q(listBuilderY);
    }

    /* JADX WARN: Code restructure failed: missing block: B:145:0x04d5, code lost:
    
        if (r1 == r2) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0284, code lost:
    
        if (kotlinx.coroutines.a.f(r3, r8) == r2) goto L146;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x046f  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0472  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x04e9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x023d A[PHI: r0 r3 r5 r6
      0x023d: PHI (r0v9 int) = (r0v5 int), (r0v10 int) binds: [B:24:0x0127, B:59:0x0239] A[DONT_GENERATE, DONT_INLINE]
      0x023d: PHI (r3v11 long) = (r3v8 long), (r3v12 long) binds: [B:24:0x0127, B:59:0x0239] A[DONT_GENERATE, DONT_INLINE]
      0x023d: PHI (r5v12 S7.q) = (r5v8 S7.q), (r5v13 S7.q) binds: [B:24:0x0127, B:59:0x0239] A[DONT_GENERATE, DONT_INLINE]
      0x023d: PHI (r6v12 java.lang.String) = (r6v8 java.lang.String), (r6v13 java.lang.String) binds: [B:24:0x0127, B:59:0x0239] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x026a A[PHI: r0 r1 r3 r5 r6
      0x026a: PHI (r0v7 int) = (r0v6 int), (r0v9 int) binds: [B:23:0x0116, B:62:0x0266] A[DONT_GENERATE, DONT_INLINE]
      0x026a: PHI (r1v5 java.lang.Object) = (r1v1 java.lang.Object), (r1v11 java.lang.Object) binds: [B:23:0x0116, B:62:0x0266] A[DONT_GENERATE, DONT_INLINE]
      0x026a: PHI (r3v10 long) = (r3v9 long), (r3v11 long) binds: [B:23:0x0116, B:62:0x0266] A[DONT_GENERATE, DONT_INLINE]
      0x026a: PHI (r5v11 S7.q) = (r5v10 S7.q), (r5v12 S7.q) binds: [B:23:0x0116, B:62:0x0266] A[DONT_GENERATE, DONT_INLINE]
      0x026a: PHI (r6v11 java.lang.String) = (r6v10 java.lang.String), (r6v12 java.lang.String) binds: [B:23:0x0116, B:62:0x0266] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0326  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:127:0x041b -> B:106:0x036b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:142:0x0499 -> B:143:0x049d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:151:0x04e3 -> B:75:0x0299). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x0284 -> B:22:0x0112). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object write(java.lang.String r24, long r25, com.mdisdk.capability.TagWriteMode r27, S7.q r28, H7.c<? super java.lang.Boolean> r29) {
        /*
            Method dump skipped, instructions count: 1292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mdisdk.capability.TagTextWriter.write(java.lang.String, long, com.mdisdk.capability.TagWriteMode, S7.q, H7.c):java.lang.Object");
    }
}
