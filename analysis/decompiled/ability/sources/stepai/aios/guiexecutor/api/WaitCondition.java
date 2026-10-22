package stepai.aios.guiexecutor.api;

import B7.a;
import androidx.compose.foundation.b;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lstepai/aios/guiexecutor/api/WaitCondition;", "", AppAgent.CONSTRUCT, "()V", "ElementAppears", "ElementDisappears", "TextAppears", "ScreenIdle", "Lstepai/aios/guiexecutor/api/WaitCondition$ElementAppears;", "Lstepai/aios/guiexecutor/api/WaitCondition$ElementDisappears;", "Lstepai/aios/guiexecutor/api/WaitCondition$ScreenIdle;", "Lstepai/aios/guiexecutor/api/WaitCondition$TextAppears;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class WaitCondition {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lstepai/aios/guiexecutor/api/WaitCondition$ElementAppears;", "Lstepai/aios/guiexecutor/api/WaitCondition;", "selector", "Lstepai/aios/guiexecutor/api/ElementSelector;", AppAgent.CONSTRUCT, "(Lstepai/aios/guiexecutor/api/ElementSelector;)V", "getSelector", "()Lstepai/aios/guiexecutor/api/ElementSelector;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ElementAppears extends WaitCondition {
        private final ElementSelector selector;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ElementAppears(ElementSelector selector) {
            super(null);
            k.f(selector, "selector");
            this.selector = selector;
        }

        public static /* synthetic */ ElementAppears copy$default(ElementAppears elementAppears, ElementSelector elementSelector, int i, Object obj) {
            if ((i & 1) != 0) {
                elementSelector = elementAppears.selector;
            }
            return elementAppears.copy(elementSelector);
        }

        /* renamed from: component1, reason: from getter */
        public final ElementSelector getSelector() {
            return this.selector;
        }

        public final ElementAppears copy(ElementSelector selector) {
            k.f(selector, "selector");
            return new ElementAppears(selector);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ElementAppears) && k.b(this.selector, ((ElementAppears) other).selector);
        }

        public final ElementSelector getSelector() {
            return this.selector;
        }

        public int hashCode() {
            return this.selector.hashCode();
        }

        public String toString() {
            return "ElementAppears(selector=" + this.selector + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lstepai/aios/guiexecutor/api/WaitCondition$ElementDisappears;", "Lstepai/aios/guiexecutor/api/WaitCondition;", "selector", "Lstepai/aios/guiexecutor/api/ElementSelector;", AppAgent.CONSTRUCT, "(Lstepai/aios/guiexecutor/api/ElementSelector;)V", "getSelector", "()Lstepai/aios/guiexecutor/api/ElementSelector;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ElementDisappears extends WaitCondition {
        private final ElementSelector selector;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ElementDisappears(ElementSelector selector) {
            super(null);
            k.f(selector, "selector");
            this.selector = selector;
        }

        public static /* synthetic */ ElementDisappears copy$default(ElementDisappears elementDisappears, ElementSelector elementSelector, int i, Object obj) {
            if ((i & 1) != 0) {
                elementSelector = elementDisappears.selector;
            }
            return elementDisappears.copy(elementSelector);
        }

        /* renamed from: component1, reason: from getter */
        public final ElementSelector getSelector() {
            return this.selector;
        }

        public final ElementDisappears copy(ElementSelector selector) {
            k.f(selector, "selector");
            return new ElementDisappears(selector);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ElementDisappears) && k.b(this.selector, ((ElementDisappears) other).selector);
        }

        public final ElementSelector getSelector() {
            return this.selector;
        }

        public int hashCode() {
            return this.selector.hashCode();
        }

        public String toString() {
            return "ElementDisappears(selector=" + this.selector + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lstepai/aios/guiexecutor/api/WaitCondition$ScreenIdle;", "Lstepai/aios/guiexecutor/api/WaitCondition;", "idleTime", "", AppAgent.CONSTRUCT, "(J)V", "getIdleTime", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ScreenIdle extends WaitCondition {
        private final long idleTime;

        public ScreenIdle(long j5) {
            super(null);
            this.idleTime = j5;
        }

        public static /* synthetic */ ScreenIdle copy$default(ScreenIdle screenIdle, long j5, int i, Object obj) {
            if ((i & 1) != 0) {
                j5 = screenIdle.idleTime;
            }
            return screenIdle.copy(j5);
        }

        /* renamed from: component1, reason: from getter */
        public final long getIdleTime() {
            return this.idleTime;
        }

        public final ScreenIdle copy(long idleTime) {
            return new ScreenIdle(idleTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ScreenIdle) && this.idleTime == ((ScreenIdle) other).idleTime;
        }

        public final long getIdleTime() {
            return this.idleTime;
        }

        public int hashCode() {
            return Long.hashCode(this.idleTime);
        }

        public String toString() {
            return b.q(this.idleTime, "ScreenIdle(idleTime=", ")");
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lstepai/aios/guiexecutor/api/WaitCondition$TextAppears;", "Lstepai/aios/guiexecutor/api/WaitCondition;", "text", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TextAppears extends WaitCondition {
        private final String text;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TextAppears(String text) {
            super(null);
            k.f(text, "text");
            this.text = text;
        }

        public static /* synthetic */ TextAppears copy$default(TextAppears textAppears, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = textAppears.text;
            }
            return textAppears.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public final TextAppears copy(String text) {
            k.f(text, "text");
            return new TextAppears(text);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TextAppears) && k.b(this.text, ((TextAppears) other).text);
        }

        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return a.m("TextAppears(text=", this.text, ")");
        }
    }

    public /* synthetic */ WaitCondition(e eVar) {
        this();
    }

    private WaitCondition() {
    }
}
