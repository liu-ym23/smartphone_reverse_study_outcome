package com.android.ttcjpaysdk.base.h5.cjjsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.android.ttcjpaysdk.verify.constants.DyVerifyEventConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\t\n\u000bB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbContacts;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbContacts$ContactsInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbContacts$ContactsOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "ContactsInput", "ContactsItem", "ContactsOutput", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbContacts extends AbsJSBMethod<ContactsInput, ContactsOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbContacts$ContactsInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "action", "", DyVerifyEventConstants.EventParam.BIZ_SCENE, "dialog_title", "confirm_button_text", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ContactsInput implements IJSBParams {
        public String action;
        public String biz_scene;
        public String confirm_button_text;
        public String dialog_title;

        public ContactsInput() {
            this(null, null, null, null, 15, null);
        }

        public ContactsInput(String r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "action");
            Intrinsics.checkNotNullParameter(r101, DyVerifyEventConstants.EventParam.BIZ_SCENE);
            Intrinsics.checkNotNullParameter(r102, "dialog_title");
            Intrinsics.checkNotNullParameter(r103, "confirm_button_text");
            this.action = r100;
            this.biz_scene = r101;
            this.dialog_title = r102;
            this.confirm_button_text = r103;
        }

        public /* synthetic */ ContactsInput(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = "";
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = "";
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = "";
        L14:
            this(r100, r101, r102, r103);
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbContacts$ContactsItem;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "name", "", "phone_number_list", "", "(Ljava/lang/String;Ljava/util/List;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ContactsItem implements IJSBParams {
        public String name;
        public List<String> phone_number_list;

        /* JADX WARN: Multi-variable type inference failed */
        public ContactsItem() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public ContactsItem(String r100, List<String> r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, "phone_number_list");
            this.name = r100;
            this.phone_number_list = r101;
        }

        public /* synthetic */ ContactsItem(String r100, List r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = CollectionsKt.emptyList();
        L8:
            this(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B3\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbContacts$ContactsOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "contacts", "", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbContacts$ContactsItem;", "has_contact_permission", "", "error_code", "", "error_msg", "", "(Ljava/util/List;ZILjava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ContactsOutput extends JSBBaseOutput {
        public List<ContactsItem> contacts;
        public int error_code;
        public String error_msg;
        public boolean has_contact_permission;

        public ContactsOutput() {
            this(null, false, 0, null, 15, null);
        }

        public ContactsOutput(List<ContactsItem> r100, boolean r101, int r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "contacts");
            Intrinsics.checkNotNullParameter(r103, "error_msg");
            this.contacts = r100;
            this.has_contact_permission = r101;
            this.error_code = r102;
            this.error_msg = r103;
        }

        public /* synthetic */ ContactsOutput(List r100, boolean r101, int r102, String r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = CollectionsKt.emptyList();
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = false;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = 0;
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = "";
        L14:
            this(r100, r101, r102, r103);
        }
    }

    public AbsJsbContacts() {
        this.name = "ttcjpay.contacts";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
