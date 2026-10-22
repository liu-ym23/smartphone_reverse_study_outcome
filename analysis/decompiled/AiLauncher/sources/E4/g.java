package E4;

import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.floatcard.api.FloatCardActionStyle;
import com.stepos.agentframework.floatcard.api.FloatCardOptionStyle;
import com.stepos.agentframework.floatcard.api.SelectionMode;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0006\u0007\bR\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0001\u0003\t\n\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"LE4/g;", "", "", "getId", "()Ljava/lang/String;", "id", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "c", "LE4/g$a;", "LE4/g$b;", "LE4/g$c;", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface g {
    String getId();

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0019\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\t\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b \u0010\u001fR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010!\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"LE4/g$a;", "LE4/g;", "", "id", "label", "Lcom/stepos/agentframework/floatcard/api/FloatCardActionStyle;", "style", "", "immediate", "required", "Landroid/os/Bundle;", "payload", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/floatcard/api/FloatCardActionStyle;ZZLandroid/os/Bundle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", Const.INTENT_KEY_APIKEY, "Lcom/stepos/agentframework/floatcard/api/FloatCardActionStyle;", "getStyle", "()Lcom/stepos/agentframework/floatcard/api/FloatCardActionStyle;", "Z", "getImmediate", "()Z", "getRequired", "Landroid/os/Bundle;", Const.INTENT_KEY_PKGNAME, "()Landroid/os/Bundle;", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: E4.g$a, reason: from toString */
    public static final /* data */ class ActionButton implements g {
        private final String id;
        private final boolean immediate;
        private final String label;
        private final Bundle payload;
        private final boolean required;
        private final FloatCardActionStyle style;

        public ActionButton(String id, String label, FloatCardActionStyle style, boolean z10, boolean z11, Bundle payload) {
            kotlin.jvm.internal.p.i(id, "id");
            kotlin.jvm.internal.p.i(label, "label");
            kotlin.jvm.internal.p.i(style, "style");
            kotlin.jvm.internal.p.i(payload, "payload");
            this.id = id;
            this.label = label;
            this.style = style;
            this.immediate = z10;
            this.required = z11;
            this.payload = payload;
        }

        /* renamed from: a, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        /* renamed from: b, reason: from getter */
        public final Bundle getPayload() {
            return this.payload;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActionButton)) {
                return false;
            }
            ActionButton actionButton = (ActionButton) other;
            return kotlin.jvm.internal.p.d(this.id, actionButton.id) && kotlin.jvm.internal.p.d(this.label, actionButton.label) && this.style == actionButton.style && this.immediate == actionButton.immediate && this.required == actionButton.required && kotlin.jvm.internal.p.d(this.payload, actionButton.payload);
        }

        @Override // E4.g
        public String getId() {
            return this.id;
        }

        public int hashCode() {
            return (((((((((this.id.hashCode() * 31) + this.label.hashCode()) * 31) + this.style.hashCode()) * 31) + Boolean.hashCode(this.immediate)) * 31) + Boolean.hashCode(this.required)) * 31) + this.payload.hashCode();
        }

        public String toString() {
            return "ActionButton(id=" + this.id + ", label=" + this.label + ", style=" + this.style + ", immediate=" + this.immediate + ", required=" + this.required + ", payload=" + this.payload + ")";
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ ActionButton(String str, String str2, FloatCardActionStyle floatCardActionStyle, boolean z10, boolean z11, Bundle EMPTY, int i10, kotlin.jvm.internal.i iVar) {
            FloatCardActionStyle floatCardActionStyle2 = (i10 & 4) != 0 ? FloatCardActionStyle.Secondary : floatCardActionStyle;
            boolean z12 = (i10 & 8) != 0 ? true : z10;
            boolean z13 = (i10 & 16) != 0 ? false : z11;
            if ((i10 & 32) != 0) {
                EMPTY = Bundle.EMPTY;
                kotlin.jvm.internal.p.h(EMPTY, "EMPTY");
            }
            this(str, str2, floatCardActionStyle2, z12, z13, EMPTY);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u0011R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001b\u0010\u0011R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010\r\u001a\u00020\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"LE4/g$b;", "LE4/g;", "", "id", "title", "", "LE4/h;", "options", "Lcom/stepos/agentframework/floatcard/api/SelectionMode;", "mode", "Lcom/stepos/agentframework/floatcard/api/FloatCardOptionStyle;", "optionStyle", "", "required", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/stepos/agentframework/floatcard/api/SelectionMode;Lcom/stepos/agentframework/floatcard/api/FloatCardOptionStyle;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "e", "Ljava/util/List;", "c", "()Ljava/util/List;", "Lcom/stepos/agentframework/floatcard/api/SelectionMode;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/agentframework/floatcard/api/SelectionMode;", "Lcom/stepos/agentframework/floatcard/api/FloatCardOptionStyle;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/agentframework/floatcard/api/FloatCardOptionStyle;", "Z", Const.INTENT_KEY_UMID, "()Z", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: E4.g$b, reason: from toString */
    public static final /* data */ class Selection implements g {
        private final String id;
        private final SelectionMode mode;
        private final FloatCardOptionStyle optionStyle;
        private final List<FloatCardOption> options;
        private final boolean required;
        private final String title;

        public Selection(String id, String str, List<FloatCardOption> options, SelectionMode mode, FloatCardOptionStyle optionStyle, boolean z10) {
            kotlin.jvm.internal.p.i(id, "id");
            kotlin.jvm.internal.p.i(options, "options");
            kotlin.jvm.internal.p.i(mode, "mode");
            kotlin.jvm.internal.p.i(optionStyle, "optionStyle");
            this.id = id;
            this.title = str;
            this.options = options;
            this.mode = mode;
            this.optionStyle = optionStyle;
            this.required = z10;
        }

        /* renamed from: a, reason: from getter */
        public final SelectionMode getMode() {
            return this.mode;
        }

        /* renamed from: b, reason: from getter */
        public final FloatCardOptionStyle getOptionStyle() {
            return this.optionStyle;
        }

        public final List<FloatCardOption> c() {
            return this.options;
        }

        /* renamed from: d, reason: from getter */
        public boolean getRequired() {
            return this.required;
        }

        /* renamed from: e, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Selection)) {
                return false;
            }
            Selection selection = (Selection) other;
            return kotlin.jvm.internal.p.d(this.id, selection.id) && kotlin.jvm.internal.p.d(this.title, selection.title) && kotlin.jvm.internal.p.d(this.options, selection.options) && this.mode == selection.mode && this.optionStyle == selection.optionStyle && this.required == selection.required;
        }

        @Override // E4.g
        public String getId() {
            return this.id;
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.title;
            return ((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.options.hashCode()) * 31) + this.mode.hashCode()) * 31) + this.optionStyle.hashCode()) * 31) + Boolean.hashCode(this.required);
        }

        public String toString() {
            return "Selection(id=" + this.id + ", title=" + this.title + ", options=" + this.options + ", mode=" + this.mode + ", optionStyle=" + this.optionStyle + ", required=" + this.required + ")";
        }

        public /* synthetic */ Selection(String str, String str2, List list, SelectionMode selectionMode, FloatCardOptionStyle floatCardOptionStyle, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
            this(str, (i10 & 2) != 0 ? null : str2, list, (i10 & 8) != 0 ? SelectionMode.Single : selectionMode, (i10 & 16) != 0 ? FloatCardOptionStyle.Checkmark : floatCardOptionStyle, (i10 & 32) != 0 ? true : z10);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0010R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0019\u0010\u0010R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u001a\u0010\u0010R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u001b\u0010\u0010R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u000b\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b\"\u0010!R\u001a\u0010\f\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b#\u0010!¨\u0006$"}, d2 = {"LE4/g$c;", "LE4/g;", "", "id", "title", "hint", "defaultValue", "", "maxLength", "", "showVoiceInput", com.stepos.ailauncher.chat.util.g.REASON_RECORDING, "required", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZZZ)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getTitle", "getHint", "getDefaultValue", "Ljava/lang/Integer;", "getMaxLength", "()Ljava/lang/Integer;", "Z", "getShowVoiceInput", "()Z", "getRecording", "getRequired", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: E4.g$c, reason: from toString */
    public static final /* data */ class TextInput implements g {
        private final String defaultValue;
        private final String hint;
        private final String id;
        private final Integer maxLength;
        private final boolean recording;
        private final boolean required;
        private final boolean showVoiceInput;
        private final String title;

        public TextInput(String id, String str, String str2, String str3, Integer num, boolean z10, boolean z11, boolean z12) {
            kotlin.jvm.internal.p.i(id, "id");
            this.id = id;
            this.title = str;
            this.hint = str2;
            this.defaultValue = str3;
            this.maxLength = num;
            this.showVoiceInput = z10;
            this.recording = z11;
            this.required = z12;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TextInput)) {
                return false;
            }
            TextInput textInput = (TextInput) other;
            return kotlin.jvm.internal.p.d(this.id, textInput.id) && kotlin.jvm.internal.p.d(this.title, textInput.title) && kotlin.jvm.internal.p.d(this.hint, textInput.hint) && kotlin.jvm.internal.p.d(this.defaultValue, textInput.defaultValue) && kotlin.jvm.internal.p.d(this.maxLength, textInput.maxLength) && this.showVoiceInput == textInput.showVoiceInput && this.recording == textInput.recording && this.required == textInput.required;
        }

        @Override // E4.g
        public String getId() {
            return this.id;
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.title;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.hint;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.defaultValue;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Integer num = this.maxLength;
            return ((((((iHashCode4 + (num != null ? num.hashCode() : 0)) * 31) + Boolean.hashCode(this.showVoiceInput)) * 31) + Boolean.hashCode(this.recording)) * 31) + Boolean.hashCode(this.required);
        }

        public String toString() {
            return "TextInput(id=" + this.id + ", title=" + this.title + ", hint=" + this.hint + ", defaultValue=" + this.defaultValue + ", maxLength=" + this.maxLength + ", showVoiceInput=" + this.showVoiceInput + ", recording=" + this.recording + ", required=" + this.required + ")";
        }

        public /* synthetic */ TextInput(String str, String str2, String str3, String str4, Integer num, boolean z10, boolean z11, boolean z12, int i10, kotlin.jvm.internal.i iVar) {
            this(str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : num, (i10 & 32) != 0 ? true : z10, (i10 & 64) != 0 ? false : z11, (i10 & 128) != 0 ? false : z12);
        }
    }
}
