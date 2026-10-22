package com.stepos.widget.recipient;

import C6.a;
import I6.b;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0000\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R2\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R2\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010$\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(¨\u0006."}, d2 = {"com/stepos/widget/recipient/StepOSRecipientEdit$SavedState", "Landroidx/customview/view/AbsSavedState;", "Landroid/os/Parcelable;", "superState", AppAgent.CONSTRUCT, "(Landroid/os/Parcelable;)V", "Landroid/os/Parcel;", AgentBusWakeContract.EXTRA_SOURCE, "Ljava/lang/ClassLoader;", "loader", "(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V", "dest", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "addresses", "Ljava/util/ArrayList;", "getAddresses", "()Ljava/util/ArrayList;", "setAddresses", "(Ljava/util/ArrayList;)V", "names", "getNames", "setNames", "editText", "Ljava/lang/String;", "getEditText", "()Ljava/lang/String;", "setEditText", "(Ljava/lang/String;)V", "inputType", "I", "getInputType", "()I", "setInputType", "(I)V", "colorType", "getColorType", "setColorType", "Companion", "I6/b", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StepOSRecipientEdit$SavedState extends AbsSavedState {
    private ArrayList<String> addresses;
    private int colorType;
    private String editText;
    private int inputType;
    private ArrayList<String> names;
    public static final b Companion = new b();
    public static final Parcelable.Creator<StepOSRecipientEdit$SavedState> CREATOR = new a(2);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSRecipientEdit$SavedState(Parcelable superState) {
        super(superState);
        k.f(superState, "superState");
        this.addresses = new ArrayList<>();
        this.names = new ArrayList<>();
        this.editText = "";
    }

    public final ArrayList<String> getAddresses() {
        return this.addresses;
    }

    public final int getColorType() {
        return this.colorType;
    }

    public final String getEditText() {
        return this.editText;
    }

    public final int getInputType() {
        return this.inputType;
    }

    public final ArrayList<String> getNames() {
        return this.names;
    }

    public final void setAddresses(ArrayList<String> arrayList) {
        k.f(arrayList, "<set-?>");
        this.addresses = arrayList;
    }

    public final void setColorType(int i) {
        this.colorType = i;
    }

    public final void setEditText(String str) {
        k.f(str, "<set-?>");
        this.editText = str;
    }

    public final void setInputType(int i) {
        this.inputType = i;
    }

    public final void setNames(ArrayList<String> arrayList) {
        k.f(arrayList, "<set-?>");
        this.names = arrayList;
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        super.writeToParcel(dest, flags);
        dest.writeStringList(this.addresses);
        dest.writeStringList(this.names);
        dest.writeString(this.editText);
        dest.writeInt(this.inputType);
        dest.writeInt(this.colorType);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSRecipientEdit$SavedState(Parcel source, ClassLoader classLoader) {
        super(source, classLoader);
        k.f(source, "source");
        this.addresses = new ArrayList<>();
        this.names = new ArrayList<>();
        this.editText = "";
        ArrayList<String> arrayListCreateStringArrayList = source.createStringArrayList();
        this.addresses = arrayListCreateStringArrayList == null ? new ArrayList<>() : arrayListCreateStringArrayList;
        ArrayList<String> arrayListCreateStringArrayList2 = source.createStringArrayList();
        this.names = arrayListCreateStringArrayList2 == null ? new ArrayList<>() : arrayListCreateStringArrayList2;
        String string = source.readString();
        this.editText = string != null ? string : "";
        this.inputType = source.readInt();
        this.colorType = source.readInt();
    }
}
