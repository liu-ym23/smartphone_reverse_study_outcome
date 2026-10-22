package androidx.compose.foundation.text;

import S7.k;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a#\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\"\u001a\u0010\u0007\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", "", "shortcutModifier", "Landroidx/compose/foundation/text/KeyMapping;", "commonKeyMapping", "(LS7/k;)Landroidx/compose/foundation/text/KeyMapping;", "defaultKeyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "getDefaultKeyMapping", "()Landroidx/compose/foundation/text/KeyMapping;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class KeyMappingKt {
    private static final KeyMapping defaultKeyMapping;

    static {
        final KeyMapping keyMappingCommonKeyMapping = commonKeyMapping(new PropertyReference1Impl() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, Z7.s
            public Object get(Object obj) {
                return Boolean.valueOf(KeyEvent_androidKt.m5279isCtrlPressedZmokQxo(((KeyEvent) obj).m5264unboximpl()));
            }
        });
        defaultKeyMapping = new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$2$1
            @Override // androidx.compose.foundation.text.KeyMapping
            /* renamed from: map-ZmokQxo */
            public KeyCommand mo1025mapZmokQxo(android.view.KeyEvent event) {
                KeyCommand keyCommand = null;
                if (KeyEvent_androidKt.m5281isShiftPressedZmokQxo(event) && KeyEvent_androidKt.m5279isCtrlPressedZmokQxo(event)) {
                    long jM5275getKeyZmokQxo = KeyEvent_androidKt.m5275getKeyZmokQxo(event);
                    MappedKeys mappedKeys = MappedKeys.INSTANCE;
                    if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo, mappedKeys.m1068getDirectionLeftEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LEFT_WORD;
                    } else if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo, mappedKeys.m1069getDirectionRightEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_RIGHT_WORD;
                    } else if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo, mappedKeys.m1070getDirectionUpEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_PREV_PARAGRAPH;
                    } else if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo, mappedKeys.m1067getDirectionDownEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_NEXT_PARAGRAPH;
                    }
                } else if (KeyEvent_androidKt.m5279isCtrlPressedZmokQxo(event)) {
                    long jM5275getKeyZmokQxo2 = KeyEvent_androidKt.m5275getKeyZmokQxo(event);
                    MappedKeys mappedKeys2 = MappedKeys.INSTANCE;
                    if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo2, mappedKeys2.m1068getDirectionLeftEK5gGoQ())) {
                        keyCommand = KeyCommand.LEFT_WORD;
                    } else if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo2, mappedKeys2.m1069getDirectionRightEK5gGoQ())) {
                        keyCommand = KeyCommand.RIGHT_WORD;
                    } else if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo2, mappedKeys2.m1070getDirectionUpEK5gGoQ())) {
                        keyCommand = KeyCommand.PREV_PARAGRAPH;
                    } else if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo2, mappedKeys2.m1067getDirectionDownEK5gGoQ())) {
                        keyCommand = KeyCommand.NEXT_PARAGRAPH;
                    } else if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo2, mappedKeys2.m1072getHEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_PREV_CHAR;
                    } else if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo2, mappedKeys2.m1066getDeleteEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_NEXT_WORD;
                    } else if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo2, mappedKeys2.m1062getBackspaceEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_PREV_WORD;
                    } else if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo2, mappedKeys2.m1061getBackslashEK5gGoQ())) {
                        keyCommand = KeyCommand.DESELECT;
                    }
                } else if (KeyEvent_androidKt.m5281isShiftPressedZmokQxo(event)) {
                    long jM5275getKeyZmokQxo3 = KeyEvent_androidKt.m5275getKeyZmokQxo(event);
                    MappedKeys mappedKeys3 = MappedKeys.INSTANCE;
                    if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo3, mappedKeys3.m1075getMoveHomeEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LINE_LEFT;
                    } else if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo3, mappedKeys3.m1074getMoveEndEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LINE_RIGHT;
                    }
                } else if (KeyEvent_androidKt.m5278isAltPressedZmokQxo(event)) {
                    long jM5275getKeyZmokQxo4 = KeyEvent_androidKt.m5275getKeyZmokQxo(event);
                    MappedKeys mappedKeys4 = MappedKeys.INSTANCE;
                    if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo4, mappedKeys4.m1062getBackspaceEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_FROM_LINE_START;
                    } else if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo4, mappedKeys4.m1066getDeleteEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_TO_LINE_END;
                    }
                }
                return keyCommand == null ? keyMappingCommonKeyMapping.mo1025mapZmokQxo(event) : keyCommand;
            }
        };
    }

    public static final KeyMapping commonKeyMapping(final k kVar) {
        return new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt.commonKeyMapping.1
            @Override // androidx.compose.foundation.text.KeyMapping
            /* renamed from: map-ZmokQxo */
            public KeyCommand mo1025mapZmokQxo(android.view.KeyEvent event) {
                if (((Boolean) kVar.invoke(KeyEvent.m5258boximpl(event))).booleanValue() && KeyEvent_androidKt.m5281isShiftPressedZmokQxo(event)) {
                    if (Key.m4967equalsimpl0(KeyEvent_androidKt.m5275getKeyZmokQxo(event), MappedKeys.INSTANCE.m1083getZEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    return null;
                }
                if (((Boolean) kVar.invoke(KeyEvent.m5258boximpl(event))).booleanValue()) {
                    long jM5275getKeyZmokQxo = KeyEvent_androidKt.m5275getKeyZmokQxo(event);
                    MappedKeys mappedKeys = MappedKeys.INSTANCE;
                    if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo, mappedKeys.m1063getCEK5gGoQ()) ? true : Key.m4967equalsimpl0(jM5275getKeyZmokQxo, mappedKeys.m1073getInsertEK5gGoQ())) {
                        return KeyCommand.COPY;
                    }
                    if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo, mappedKeys.m1080getVEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo, mappedKeys.m1081getXEK5gGoQ())) {
                        return KeyCommand.CUT;
                    }
                    if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo, mappedKeys.m1060getAEK5gGoQ())) {
                        return KeyCommand.SELECT_ALL;
                    }
                    if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo, mappedKeys.m1082getYEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo, mappedKeys.m1083getZEK5gGoQ())) {
                        return KeyCommand.UNDO;
                    }
                    return null;
                }
                if (KeyEvent_androidKt.m5279isCtrlPressedZmokQxo(event)) {
                    return null;
                }
                if (KeyEvent_androidKt.m5281isShiftPressedZmokQxo(event)) {
                    long jM5275getKeyZmokQxo2 = KeyEvent_androidKt.m5275getKeyZmokQxo(event);
                    MappedKeys mappedKeys2 = MappedKeys.INSTANCE;
                    if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo2, mappedKeys2.m1068getDirectionLeftEK5gGoQ())) {
                        return KeyCommand.SELECT_LEFT_CHAR;
                    }
                    if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo2, mappedKeys2.m1069getDirectionRightEK5gGoQ())) {
                        return KeyCommand.SELECT_RIGHT_CHAR;
                    }
                    if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo2, mappedKeys2.m1070getDirectionUpEK5gGoQ())) {
                        return KeyCommand.SELECT_UP;
                    }
                    if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo2, mappedKeys2.m1067getDirectionDownEK5gGoQ())) {
                        return KeyCommand.SELECT_DOWN;
                    }
                    if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo2, mappedKeys2.m1077getPageUpEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_UP;
                    }
                    if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo2, mappedKeys2.m1076getPageDownEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_DOWN;
                    }
                    if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo2, mappedKeys2.m1075getMoveHomeEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_START;
                    }
                    if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo2, mappedKeys2.m1074getMoveEndEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_END;
                    }
                    if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo2, mappedKeys2.m1073getInsertEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    return null;
                }
                long jM5275getKeyZmokQxo3 = KeyEvent_androidKt.m5275getKeyZmokQxo(event);
                MappedKeys mappedKeys3 = MappedKeys.INSTANCE;
                if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo3, mappedKeys3.m1068getDirectionLeftEK5gGoQ())) {
                    return KeyCommand.LEFT_CHAR;
                }
                if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo3, mappedKeys3.m1069getDirectionRightEK5gGoQ())) {
                    return KeyCommand.RIGHT_CHAR;
                }
                if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo3, mappedKeys3.m1070getDirectionUpEK5gGoQ())) {
                    return KeyCommand.UP;
                }
                if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo3, mappedKeys3.m1067getDirectionDownEK5gGoQ())) {
                    return KeyCommand.DOWN;
                }
                if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo3, mappedKeys3.m1077getPageUpEK5gGoQ())) {
                    return KeyCommand.PAGE_UP;
                }
                if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo3, mappedKeys3.m1076getPageDownEK5gGoQ())) {
                    return KeyCommand.PAGE_DOWN;
                }
                if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo3, mappedKeys3.m1075getMoveHomeEK5gGoQ())) {
                    return KeyCommand.LINE_START;
                }
                if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo3, mappedKeys3.m1074getMoveEndEK5gGoQ())) {
                    return KeyCommand.LINE_END;
                }
                if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo3, mappedKeys3.m1071getEnterEK5gGoQ())) {
                    return KeyCommand.NEW_LINE;
                }
                if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo3, mappedKeys3.m1062getBackspaceEK5gGoQ())) {
                    return KeyCommand.DELETE_PREV_CHAR;
                }
                if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo3, mappedKeys3.m1066getDeleteEK5gGoQ())) {
                    return KeyCommand.DELETE_NEXT_CHAR;
                }
                if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo3, mappedKeys3.m1078getPasteEK5gGoQ())) {
                    return KeyCommand.PASTE;
                }
                if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo3, mappedKeys3.m1065getCutEK5gGoQ())) {
                    return KeyCommand.CUT;
                }
                if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo3, mappedKeys3.m1064getCopyEK5gGoQ())) {
                    return KeyCommand.COPY;
                }
                if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo3, mappedKeys3.m1079getTabEK5gGoQ())) {
                    return KeyCommand.TAB;
                }
                return null;
            }
        };
    }

    public static final KeyMapping getDefaultKeyMapping() {
        return defaultKeyMapping;
    }
}
