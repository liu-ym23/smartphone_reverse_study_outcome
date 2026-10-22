package androidx.datastore.preferences.protobuf;

import com.stepos.policy.sdk.bean.PolicyBasicListVO;

/* loaded from: classes.dex */
final class m0 {

    static class a implements b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractC0488h f10096a;

        a(AbstractC0488h abstractC0488h) {
            this.f10096a = abstractC0488h;
        }

        @Override // androidx.datastore.preferences.protobuf.m0.b
        public byte a(int i5) {
            return this.f10096a.c(i5);
        }

        @Override // androidx.datastore.preferences.protobuf.m0.b
        public int size() {
            return this.f10096a.size();
        }
    }

    private interface b {
        byte a(int i5);

        int size();
    }

    static String a(AbstractC0488h abstractC0488h) {
        return b(new a(abstractC0488h));
    }

    static String b(b bVar) {
        StringBuilder sb = new StringBuilder(bVar.size());
        for (int i5 = 0; i5 < bVar.size(); i5++) {
            byte bA = bVar.a(i5);
            if (bA == 34) {
                sb.append("\\\"");
            } else if (bA == 39) {
                sb.append("\\'");
            } else if (bA != 92) {
                switch (bA) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                        sb.append("\\t");
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                        sb.append("\\n");
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                        sb.append("\\v");
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                        sb.append("\\f");
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                        sb.append("\\r");
                        break;
                    default:
                        if (bA < 32 || bA > 126) {
                            sb.append('\\');
                            sb.append((char) (((bA >>> 6) & 3) + 48));
                            sb.append((char) (((bA >>> 3) & 7) + 48));
                            sb.append((char) ((bA & 7) + 48));
                            break;
                        } else {
                            sb.append((char) bA);
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    static String c(String str) {
        return a(AbstractC0488h.n(str));
    }
}
